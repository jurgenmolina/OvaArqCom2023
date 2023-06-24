package com.ova.arq2023.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ova.arq2023.modelo.Notificacion;

@Repository
public interface NotificacionRepositorio extends JpaRepository<Notificacion, Long>{

	
	
}