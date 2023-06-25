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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Usuario usuario = usuarioServicio.SelectUsuario(username);
            if (usuario != null && usuario.isAdmin()) {
                modelo.addAttribute("usuario", usuario);
                return "admin/admin-dashboard";
            } else {
                modelo.addAttribute("error", "No tienes permisos de administrador");
                return "index";
            }
        } else {
            return "redirect:/login";
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
}

