package com.ova.arq2023.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;
    
    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<Pregunta> preguntas = new ArrayList<>();

	
    
    // Constructor, getters y setters
}

