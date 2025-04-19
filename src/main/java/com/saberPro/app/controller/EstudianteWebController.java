package com.saberPro.app.controller;

import com.saberPro.app.model.Estudiante;
import com.saberPro.app.repository.EstudianteRepository;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteWebController {
	
	private String calcularNivelGenerico(Integer puntaje) {
	    if (puntaje == null) return "Error";

	    if (puntaje >= 191) {
	        return "Nivel 4";
	    } else if (puntaje >= 156) {
	        return "Nivel 3";
	    } else if (puntaje >= 126) {
	        return "Nivel 2";
	    } else if (puntaje >= 0) {
	        return "Nivel 1";
	    } else {
	        return "Error";
	    }
	}
	
	private Integer castToInt(Object puntaje) {
	    if (puntaje instanceof Integer) {
	        return (Integer) puntaje;
	    } else if (puntaje instanceof String) {
	        try {
	            return Integer.parseInt((String) puntaje);
	        } catch (NumberFormatException e) {
	            return null;
	        }
	    }
	    return null;
	}

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public String listarEstudiantes(HttpSession session, Model model) {
        String rol = (String) session.getAttribute("rol");
        if (!"coordinacion".equals(rol)) {
            return "redirect:/login";
        }
        model.addAttribute("listaEstudiantes", estudianteRepository.findAll());
        return "verEstudiantes";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("editMode", "false");
        return "formEstudiante"; // archivo .html
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante, Model model) {
        // Validación de puntaje mayor a 300
        if (estudiante.getPuntaje() != null) {
            Double puntaje = Double.parseDouble(estudiante.getPuntaje().toString());

            // Validar que el puntaje no sea mayor a 300
            if (puntaje > 300) {
                model.addAttribute("error", "El puntaje no puede ser mayor a 300.");
                return "formEstudiante"; // Regresar al formulario con el mensaje de error
            }

            estudiante.setNivelSaberPro(calcularNivelGenerico(castToInt(estudiante.getPuntaje())));
            estudiante.setNivelComunicacionEscrita(calcularNivelGenerico(estudiante.getComunicacionEscrita()));
            estudiante.setNivelRazonamientoCuantitativo(calcularNivelGenerico(estudiante.getRazonamientoCuantitativo()));
            estudiante.setNivelLecturaCritica(calcularNivelGenerico(estudiante.getLecturaCritica()));
            estudiante.setNivelCompetenciasCiudadanas(calcularNivelGenerico(estudiante.getCompetenciasCiudadanas()));
            estudiante.setNivelFormulacionDeProyectos(calcularNivelGenerico(estudiante.getFormulacionDeProyectos()));
            estudiante.setNivelPensamientoCientifico(calcularNivelGenerico(estudiante.getPensamientoCientifico()));
            estudiante.setNivelDisenoDeSoftware(calcularNivelGenerico(estudiante.getDisenoDeSoftware()));

            // Calcular nivel de inglés
            if (estudiante.getIngles() != null) {
                if (estudiante.getIngles() < 120) {
                    estudiante.setNivelIngles("A0");
                } else if (estudiante.getIngles() < 145) {
                    estudiante.setNivelIngles("A1");
                } else if (estudiante.getIngles() < 170) {
                    estudiante.setNivelIngles("A2");
                } else if (estudiante.getIngles() < 200) {
                    estudiante.setNivelIngles("B1");
                } else {
                    estudiante.setNivelIngles("B2");
                }
            }
        }

        // Guardar el estudiante en la base de datos
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes"; // Redirigir al listado de estudiantes
    }



    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("editMode", "true");
        return "formEstudiante";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable String id) {
        estudianteRepository.deleteById(id);
        return "redirect:/estudiantes";
    }
    
    
    @GetMapping("/perfil/{numeroRegistro}")
    public String verPerfilEstudiante(@PathVariable String numeroRegistro, Model model) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findByNumeroRegistro(numeroRegistro);

        if (optionalEstudiante.isEmpty()) {
            model.addAttribute("error", "Estudiante no encontrado");
            return "error";
        }

        Estudiante estudiante = optionalEstudiante.get();
        model.addAttribute("estudiante", estudiante);
        return "perfilEstudiante";
    }



}
