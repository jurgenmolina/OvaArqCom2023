package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VtEmu {

    @GetMapping("/virtualización-emuladores-y-entornosdearquitectura")
	public String showSistemasNumericos() {
		return "virtualización-emuladores-y-entornosdearquitectura";
	}
    
}
