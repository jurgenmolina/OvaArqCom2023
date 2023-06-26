package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Condicionalesrepetitiva {

    @GetMapping("/unidad-seis")
    public String Inicio() {
        return "unidad-seis";
    }

    @GetMapping("/examen/unidad-seis")
    public String Examen() {
        return "unidad_seis/examen-unidad-seis";
    }
   
}


