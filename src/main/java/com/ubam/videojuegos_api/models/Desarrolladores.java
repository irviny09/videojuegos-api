package com.ubam.videojuegos_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_cat_desarrolladores")
public class Desarrolladores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DesarrolladoresId")
    private int id;

    @Column(name = "Desarrolladores_Nombre", length = 45, nullable = false)
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
