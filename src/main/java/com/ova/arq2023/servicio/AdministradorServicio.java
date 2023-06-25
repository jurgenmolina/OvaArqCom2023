package com.ova.arq2023.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Pregunta;
import com.ova.arq2023.modelo.Tema;
import com.ova.arq2023.modelo.Unidad;
import java.util.List;

import javax.transaction.Transactional;

import com.ova.arq2023.modelo.Administrador;
import com.ova.arq2023.repositorio.AdminRepositorio;
import com.ova.arq2023.repositorio.ExamenRepositorio;
import com.ova.arq2023.repositorio.NotificacionRepositorio;
import com.ova.arq2023.repositorio.PreguntaRepositorio;
import com.ova.arq2023.repositorio.TemaRepositorio;
import com.ova.arq2023.repositorio.UnidadRepositorio;

@Service
@Transactional
public class AdministradorServicio implements UserDetailsService {
    
    @Autowired
    private UnidadRepositorio unidadRepositorio;
    
    @Autowired
    private TemaRepositorio temaRepositorio;
    
    @Autowired
    private ExamenRepositorio examenRepositorio;
    
    @Autowired
    private PreguntaRepositorio preguntaRepositorio;
    
    @Autowired
    private NotificacionRepositorio notificacionRepositorio;
    
    @Autowired
    private AdminRepositorio administradorRepositorio;
    
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrador administrador = administradorRepositorio.findByNombre(username);
        if (administrador == null) {
            throw new UsernameNotFoundException("Administrador no encontrado: " + username);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(administrador.getEmail())
                .password(administrador.getPassword())
                .roles("ADMIN")
                .build();
    }


    // Métodos para manejar las Unidades
    public Unidad crearUnidad(Unidad unidad) {
        return unidadRepositorio.save(unidad);
    }
    
    // Métodos para manejar los Temas
    public Tema crearTema(Tema tema) {
        return temaRepositorio.save(tema);
    }
    
    // Métodos para manejar los Exámenes
    public Examen crearExamen(Examen examen) {
        return examenRepositorio.save(examen);
    }
    
    // Métodos para manejar las Preguntas
    public Pregunta crearPregunta(Pregunta pregunta) {
        return preguntaRepositorio.save(pregunta);
    }
    
    // Métodos para manejar las Notificaciones
    public Notificacion crearNotificacion(Notificacion notificacion) {
        return notificacionRepositorio.save(notificacion);
    }


    public List<Unidad> obtenerUnidades() {
        return unidadRepositorio.findAll();
    }

    public Unidad obtenerUnidad(Long unidadId) {
        return unidadRepositorio.findById(unidadId).orElse(null);
    }

	
}
