package com.saberPro.app.controller;

import com.saberPro.app.model.Estudiante;
import com.saberPro.app.repository.EstudianteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String usuario,
                                 @RequestParam String contrasena,
                                 @RequestParam String rol,
                                 HttpSession session,
                                 Model model) {

        if ("coordinacion".equals(rol)) {
            if ("coordinacion".equals(usuario) && "coordinacion123".equals(contrasena)) {
                session.setAttribute("rol", "coordinacion");
                return "redirect:/estudiantes";
            } else {
                model.addAttribute("error", "Credenciales incorrectas para Coordinación");
                return "login";
            }
        } else if ("estudiante".equals(rol)) {
            Optional<Estudiante> estudianteOpt = estudianteRepository.findByNumeroRegistro(usuario);
            if (estudianteOpt.isPresent()) {
                Estudiante estudiante = estudianteOpt.get();
                if (estudiante.getPrimerApellido().equalsIgnoreCase(contrasena)) {
                    session.setAttribute("rol", "estudiante");
                    session.setAttribute("numeroRegistro", estudiante.getNumeroRegistro());
                    return "redirect:/estudiantes/perfil/"+ estudiante.getNumeroRegistro();
                } else {
                    model.addAttribute("error", "Contraseña incorrecta");
                    return "login";
                }
            } else {
                model.addAttribute("error", "Estudiante no encontrado");
                return "login";
            }
        }

        model.addAttribute("error", "Rol no válido");
        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
