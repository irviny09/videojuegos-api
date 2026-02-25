package com.ubam.videojuegos_api.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_ope_videojuegos")
public class Videojuegos {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Videojuegos_Titulo", length = 80, nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "Videojuegos_DesarrolladoresId", nullable = false)
    private Desarrolladores desarrolladores;

    @Column(name = "Videojuegos_FechaLanzamiento", nullable = false)
    private Date fechaLanzamiento;

    @Column(name = "Videojuegos_Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Videojuegos_EsbrId", nullable = false)
    private Esbr esbr;

    @Column(name = "Videojuegos_Precio", nullable = false)
    private float precio;

    @Column(name = "Videojuegos_Requisitos", columnDefinition = "MEDIUMTEXT")
    private String requisitos;

    @Column(name = "Videojuegos_Activo", nullable = false)
    private boolean activo;
}
