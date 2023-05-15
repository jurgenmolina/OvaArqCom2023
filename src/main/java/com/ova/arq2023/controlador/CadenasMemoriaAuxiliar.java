package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadenasMemoriaAuxiliar{

    @GetMapping("/cadenas-y-memoria-auxiliar")
	public String showSistemasNumericos() {
		return "cadenas-y-memoria-auxiliar";
	}
    
}
