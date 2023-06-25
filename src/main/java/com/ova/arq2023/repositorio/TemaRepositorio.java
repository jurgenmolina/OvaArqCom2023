package com.ova.arq2023.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.Tema;

@Repository
@EnableJpaRepositories(basePackages = "com.ova.arq2023.repositorio")

public interface TemaRepositorio extends JpaRepository <Tema, Long>{

   
    
}