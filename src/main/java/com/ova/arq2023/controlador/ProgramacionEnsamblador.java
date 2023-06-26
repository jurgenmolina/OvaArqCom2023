package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramacionEnsamblador {

    @GetMapping("/programacionenensamblador")
	public String Inicio() {
		return "programacionenensamblador";
		
		//condicionales-saltos-e-instrucciones-repetitivas
	}
    
}
