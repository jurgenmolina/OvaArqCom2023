package com.ova.arq2023.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ova.arq2023.controlador.dto.UsuarioRegistroDTO;
import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Respuesta;
import com.ova.arq2023.modelo.ResultadoExamen;
import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	public Unidad obtenerUnidad(Long id);
    public Examen obtenerExamen(Long id);
    public ResultadoExamen responderExamen(Long id, Respuesta respuestasForm);
    public ResultadoExamen obtenerResultadoExamen(Long id);
    public List<Notificacion> obtenerNotificaciones();
}
