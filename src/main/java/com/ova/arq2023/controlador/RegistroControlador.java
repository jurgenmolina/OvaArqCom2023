package com.ova.arq2023.controlador;

import java.security.Principal;
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
<<<<<<< HEAD
    public String verPaginaDeInicio(Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = principal.getName();
            Usuario usuario = usuarioServicio.SelectUsuario(username);
            if (usuario != null && usuario.isAdmin()) {
                return "redirect:/admin/admin-dashboard";
            } else {
                model.addAttribute("usuario", usuario);
                // Aquí puedes cargar los quices y pasarlos al modelo para mostrarlos en la vist
                return "index";
            }
        } else {
            return "redirect:/login";
        }
    }

    
    
    
}
=======
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
>>>>>>> f1906f4b1a364b9a52dfe23b0fc86d43a75b62a2
