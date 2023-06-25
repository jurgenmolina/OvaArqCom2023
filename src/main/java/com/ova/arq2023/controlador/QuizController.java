package com.ova.arq2023.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @GetMapping("/quiz")
    public String mostrarQuiz() {
        return "quiz";
    }

    // Otros métodos y controladores...
}
