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


@Setter
@Getter
@Entity
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Tema> temas = new ArrayList<>();
    /*
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    */
    // Constructor, getters y setters
}


