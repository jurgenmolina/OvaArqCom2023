package com.ova.arq2023.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ova.arq2023.controlador.dto.UsuarioRegistroDTO;
import com.ova.arq2023.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();

	public Usuario SelectUsuario(String email);
	
}
