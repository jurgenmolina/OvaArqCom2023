package com.ova.arq2023.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ova.arq2023.modelo.Examen;
import com.ova.arq2023.modelo.Notificacion;
import com.ova.arq2023.modelo.Pregunta;
import com.ova.arq2023.modelo.Tema;
import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.servicio.AdministradorServicio;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    @Autowired
    private AdministradorServicio administradorServicio;

    @GetMapping("/unidad/crear")
    public String crearUnidadForm(Model model) {
        model.addAttribute("unidad", new Unidad());
        return "crearUnidad";
    }

    @PostMapping("/unidad/crear")
    public String crearUnidad(@ModelAttribute Unidad unidad) {
        administradorServicio.crearUnidad(unidad);
        return "redirect:/admin/unidades";
    }

    @GetMapping("/tema/crear")
    public String crearTemaForm(Model model) {
        model.addAttribute("tema", new Tema());
        return "crearTema";
    }

    @PostMapping("/tema/crear")
    public String crearTema(@ModelAttribute Tema tema) {
        administradorServicio.crearTema(tema);
        return "redirect:/admin/temas";
    }

    @GetMapping("/examen/crear")
    public String crearExamenForm(Model model) {
        model.addAttribute("examen", new Examen());
        return "crearExamen";
    }

    @PostMapping("/examen/crear")
    public String crearExamen(@ModelAttribute Examen examen) {
        administradorServicio.crearExamen(examen);
        return "redirect:/admin/examenes";
    }

    @GetMapping("/pregunta/crear")
    public String crearPreguntaForm(Model model) {
        model.addAttribute("pregunta", new Pregunta());
        return "crearPregunta";
    }

    @PostMapping("/pregunta/crear")
    public String crearPregunta(@ModelAttribute Pregunta pregunta) {
        administradorServicio.crearPregunta(pregunta);
        return "redirect:/admin/preguntas";
    }

    @GetMapping("/notificacion/crear")
    public String crearNotificacionForm(Model model) {
        model.addAttribute("notificacion", new Notificacion());
        return "crearNotificacion";
    }

    @PostMapping("/notificacion/crear")
    public String crearNotificacion(@ModelAttribute Notificacion notificacion) {
        administradorServicio.crearNotificacion(notificacion);
        return "redirect:/admin/notificaciones";
    }
}

