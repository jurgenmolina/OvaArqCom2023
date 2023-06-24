package com.ova.arq2023.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.Pregunta;

@Repository
public interface PreguntaRepositorio extends JpaRepository <PreguntaRepositorio, Long>{

    Pregunta save(Pregunta pregunta);

    
}