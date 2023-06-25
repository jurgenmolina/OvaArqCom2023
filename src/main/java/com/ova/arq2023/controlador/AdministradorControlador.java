package com.ova.arq2023.controlador;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ova.arq2023.modelo.Unidad;
import com.ova.arq2023.servicio.AdministradorServicio;

@Controller
public class AdministradorControlador {

    @Autowired
    private AdministradorServicio administradorServicio;

    @GetMapping("/admin-dashboard")
    public String mostrarPanelAdministrador(Model model) {
        List<Unidad> unidades = administradorServicio.obtenerUnidades();
        model.addAttribute("unidades", unidades);
        model.addAttribute("unidadForm", new Unidad());
        return "admin/admin-dashboard";
    }

    @PostMapping("/crearUnidad")
    public String crearUnidad(@ModelAttribute("unidadForm") Unidad unidad, Model model) {
        Unidad unidadCreada = administradorServicio.crearUnidad(unidad);
        if (unidadCreada != null) {
            model.addAttribute("mensaje", "Unidad creada exitosamente");
        } else {
            model.addAttribute("mensaje", "Error al crear la unidad");
        }
        return "redirect:/admin-dashboard";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        // Invalidar la sesión actual
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Eliminar la cookie de sesión
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }

        // Redirigir al inicio de sesión
        return "redirect:/login";
    }
}

