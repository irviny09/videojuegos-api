package com.ubam.videojuegos_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_cat_plataformas")
public class Plataformas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlataformasId")
    private int id;

    @Column(name = "Plataformas_Nombre", length = 50, nullable = false)
    private String nombre;
}
