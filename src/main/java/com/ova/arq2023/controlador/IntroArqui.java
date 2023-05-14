package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroArqui {

    @GetMapping("/introArqui")
	public String showIntroArqui() {
		return "introArqui";
	}
    
}
