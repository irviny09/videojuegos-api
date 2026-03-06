package com.ubam.videojuegos_api.DTOs;


public class DTOVideojuego {
    
        private String titulo;
        private Integer desarrolladoresId;
        private String fechaLanzamiento;
        private String descripcion;
        private Integer esbrId;
        private Float precio;
        private String requisitos;
        private Boolean activo;
        private String categorias;
        private String plataformas;
        private int stock;

    public DTOVideojuego() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDesarrolladoresId() {
        return desarrolladoresId;
    }

    public void setDesarrolladoresId(Integer desarrolladoresId) {
        this.desarrolladoresId = desarrolladoresId;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEsbrId() {
        return esbrId;
    }

    public void setEsbrId(Integer esbrId) {
        this.esbrId = esbrId;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
