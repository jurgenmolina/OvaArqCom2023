package com.ova.arq2023.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ova.arq2023.modelo.Usuario;
import com.ova.arq2023.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }


    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        try {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioServicio.SelectUsuario(auth.getName());
        modelo.addAttribute("usuario", usuario);
        return "index";
        } catch (Exception e) {
			System.out.println("Error al cargar la página de inicio: " + e.getMessage());
			return "redirect:/";
		}
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "redirect:/";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }

    @GetMapping("/CourierPrime-Regular.ttf")
    public String error() {
        return "redirect:/";
    }


    
}
