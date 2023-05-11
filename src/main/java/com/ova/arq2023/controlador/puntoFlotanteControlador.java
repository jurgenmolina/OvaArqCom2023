package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class puntoFlotanteControlador {

    @GetMapping("/puntoflotante")
	public String showSistemasNumericos() {
		return "puntoflotante";
	}
    
}
