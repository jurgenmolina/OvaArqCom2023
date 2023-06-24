package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @GetMapping("/dashboard")
    public String adminDashboardPage(Model model) {
        // Lógica para obtener datos y mostrarlos en el panel de control del administrador
        // Puedes pasar los datos necesarios al modelo para mostrarlos en la vista
        model.addAttribute("message", "Welcome to Admin Dashboard");
        return "admin-dashboard";
    }
}
