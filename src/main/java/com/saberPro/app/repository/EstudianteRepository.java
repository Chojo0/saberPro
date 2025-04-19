package com.saberPro.app.repository;

import com.saberPro.app.model.Estudiante;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Optional<Estudiante> findByNumeroRegistro(String numeroRegistro);
}
