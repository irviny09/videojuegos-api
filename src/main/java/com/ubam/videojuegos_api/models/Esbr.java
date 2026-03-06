package com.ubam.videojuegos_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_cat_esbr")
public class Esbr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EsbrId")
    private int id;

    @Column(name = "Esbr_Esbr", length = 45, nullable = false)
    private String esbr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEsbr() {
        return esbr;
    }

    public void setEsbr(String esbr) {
        this.esbr = esbr;
    }
}
