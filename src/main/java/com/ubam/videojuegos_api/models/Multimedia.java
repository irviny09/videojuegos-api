package com.ubam.videojuegos_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_ope_multimedia")
public class Multimedia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MultimediaId")
    private int id;

    @Column(name = "Multimedia_ImagenURL", length = 200, nullable = false)
    private String imagenUrl;

    @Column(name = "Multimedia_TrailerURL", length = 200, nullable = false)
    private String trailerUrl;

    @Column(name = "Multimedia_DemoURL", length = 200, nullable = false)
    private String demoUrl;

}
