package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class programaciónEnEnsamblador {

    @GetMapping("/programaciónenensamblador")
	public String showSistemasNumericos() {
		return "programaciónenensamblador";
		
		//condicionales-saltos-e-instrucciones-repetitivas
	}
    
}
