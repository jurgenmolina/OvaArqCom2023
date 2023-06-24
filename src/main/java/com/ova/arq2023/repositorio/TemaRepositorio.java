package com.ova.arq2023.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.Tema;

@Repository
public interface TemaRepositorio extends JpaRepository <TemaRepositorio, Long>{

    Tema save(Tema tema);

    
}