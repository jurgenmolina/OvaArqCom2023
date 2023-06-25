package com.ova.arq2023.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.ResultadoExamen;

@Repository
public interface ResultadoExamenRepositorio extends JpaRepository<ResultadoExamen, Long>{

    
}