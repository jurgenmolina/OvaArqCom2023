package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Condicionalesrepetitiva {

    @GetMapping("/condicionales-saltos-e-instrucciones-repetitivas")
	public String Inicio() {
		return "condicionales-saltos-e-instrucciones-repetitivas";
	}
    
}
