package com.ubam.videojuegos_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tbl_rel_videojuegos_plataforma")
public class VideojuegosPlataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "VideojuegosId", nullable = false)
    private Videojuegos videojuegos;

    @ManyToOne
    @JoinColumn(name = "PlataformaId", nullable = false)
    private Plataformas plataforma;
}
