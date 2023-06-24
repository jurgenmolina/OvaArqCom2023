package com.ova.arq2023.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Respuesta;
import com.ova.arq2023.modelo.ResultadoExamen;
import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.servicio.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/unidad/{id}")
    public String verUnidad(@PathVariable Long id, Model model) {
        Unidad unidad = usuarioServicio.obtenerUnidad(id);
        model.addAttribute("unidad", unidad);
        return "verUnidad";
    }

    @GetMapping("/examen/{id}")
    public String verExamen(@PathVariable Long id, Model model) {
        Examen examen = usuarioServicio.obtenerExamen(id);
        model.addAttribute("examen", examen);
        return "verExamen";
    }

    @PostMapping("/examen/{id}")
    public String responderExamen(@PathVariable Long id, @ModelAttribute("respuestas") Respuesta respuestasForm) {
        ResultadoExamen resultado = usuarioServicio.responderExamen(id, respuestasForm);
        return "redirect:/Usuario/examen/" + id + "/resultado";
    }

    @GetMapping("/examen/{id}/resultado")
    public String verResultadoExamen(@PathVariable Long id, Model model) {
        ResultadoExamen resultado = usuarioServicio.obtenerResultadoExamen(id);
        model.addAttribute("resultado", resultado);
        return "verResultadoExamen";
    }

    @GetMapping("/notificaciones")
    public String verNotificaciones(Model model) {
        List<Notificacion> notificaciones = usuarioServicio.obtenerNotificaciones();
        model.addAttribute("notificaciones", notificaciones);
        return "verNotificaciones";
    }
}
