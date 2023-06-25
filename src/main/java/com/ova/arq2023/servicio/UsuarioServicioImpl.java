package com.ova.arq2023.servicio;

import java.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ova.arq2023.controlador.dto.UsuarioRegistroDTO;
import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Respuesta;
import com.ova.arq2023.modelo.ResultadoExamen;
import com.ova.arq2023.modelo.Rol;
import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.modelo.Usuario;
import com.ova.arq2023.repositorio.ExamenRepositorio;
import com.ova.arq2023.repositorio.NotificacionRepositorio;
import com.ova.arq2023.repositorio.ResultadoExamenRepositorio;
import com.ova.arq2023.repositorio.UnidadRepositorio;
import com.ova.arq2023.repositorio.UsuarioRepositorio;

import util.ResourceNotFoundException;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;
    private UnidadRepositorio unidadRepositorio;
    private ExamenRepositorio examenRepositorio;
    private ResultadoExamenRepositorio resultadoExamenRepositorio;
    private NotificacionRepositorio notificacionRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, UnidadRepositorio unidadRepositorio, ExamenRepositorio examenRepositorio, ResultadoExamenRepositorio resultadoExamenRepositorio, NotificacionRepositorio notificacionRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.unidadRepositorio = unidadRepositorio;
        this.examenRepositorio = examenRepositorio;
        this.resultadoExamenRepositorio = resultadoExamenRepositorio;
        this.notificacionRepositorio = notificacionRepositorio;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));

        if (usuarioRepositorio.count() == 0) {
            usuario.setAdmin(true);
        }

        try {
            return usuarioRepositorio.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("El correo electrónico ya está registrado. Por favor, utilice otro correo electrónico.");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (usuario.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Unidad obtenerUnidad(Long id) {
        return unidadRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unidad", "id", id));
    }

    @Override
    public Examen obtenerExamen(Long id) {
        return examenRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Examen", "id", id));
    }


    @Override
    public ResultadoExamen responderExamen(Long id, Respuesta respuestasForm) {
        Examen examen = examenRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Examen", "id", id));

        // Aquí iría la lógica para evaluar las respuestas del estudiante y obtener el puntaje obtenido
        int puntajeObtenido = 0;

        ResultadoExamen resultado = new ResultadoExamen();
        resultado.setUsuario(getUsuarioActual()); // Reemplaza esto por la lógica para obtener el usuario actual
        resultado.setExamen(examen);
        resultado.setPuntajeObtenido(puntajeObtenido);

        return resultadoExamenRepositorio.save(resultado);
    }

    private Usuario getUsuarioActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return usuarioRepositorio.findByEmail(username);
    }

    @Override
    public ResultadoExamen obtenerResultadoExamen(Long id) {
        return resultadoExamenRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoExamen", "id", id));
    }

    @Override
    public List<Notificacion> obtenerNotificaciones() {
        return notificacionRepositorio.findAll();
    }

    @Override
    public Usuario SelectUsuario(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String nombre = authentication.getName();
            return usuarioRepositorio.findByNombre(nombre);
        }
        return null;
    }




	
	
}
