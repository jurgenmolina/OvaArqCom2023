package com.ova.arq2023.repositorio;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.Administrador;
import com.ova.arq2023.modelo.Pregunta;

@Repository
public interface AdminRepositorio extends JpaRepository <Administrador, Long>{

	Administrador findByNombre(String username);

	
    
}