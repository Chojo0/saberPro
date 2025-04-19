package com.saberPro.app.controller;

import com.saberPro.app.model.Estudiante;
import com.saberPro.app.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        for (Estudiante estudiante : estudiantes) {
            Object puntaje = estudiante.getPuntaje();

            if (puntaje instanceof Number) {
                double valorNumerico = ((Number) puntaje).doubleValue();
                System.out.println("Puntaje numérico: " + valorNumerico);
            } else if (puntaje != null && puntaje.toString().equalsIgnoreCase("ANULADO")) {
                System.out.println("Puntaje ANULADO para estudiante con registro: " + estudiante.getNumeroRegistro());
            } else {
                System.out.println("Puntaje desconocido o nulo");
            }
        }

        return estudiantes;
    }

    // Buscar por número de registro
    @GetMapping("/registro/{numero}")
    public Optional<Estudiante> obtenerPorRegistro(@PathVariable String numero) {
        return estudianteRepository.findByNumeroRegistro(numero);
    }
    
    @GetMapping("/api/estudiantes")
    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        estudiantes.forEach(estudiante -> System.out.println(estudiante));
        return estudiantes;
    }

    
}
