package com.ubam.videojuegos_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_rel_videojuegos_categoria")
public class VideojuegosCategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "VideojuegosId", nullable = false)
    private Videojuegos videojuegos;

    @ManyToOne
    @JoinColumn(name = "CategoriaId", nullable = false)
    private Categoria categoria;

}
