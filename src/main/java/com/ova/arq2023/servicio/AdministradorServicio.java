package com.ova.arq2023.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Pregunta;
import com.ova.arq2023.modelo.Tema;
import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.repositorio.ExamenRepositorio;
import com.ova.arq2023.repositorio.NotificacionRepositorio;
import com.ova.arq2023.repositorio.PreguntaRepositorio;
import com.ova.arq2023.repositorio.TemaRepositorio;
import com.ova.arq2023.repositorio.UnidadRepositorio;

@Service
public class AdministradorServicio {
    
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
}
