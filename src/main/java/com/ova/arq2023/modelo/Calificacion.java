package com.ova.arq2023.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tema", referencedColumnName = "id")
    private Tema idTema;

    @Column(name = "calificacion")
    private int calificacion;

    // Constructor, getters y setters
}