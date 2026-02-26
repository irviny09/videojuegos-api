package com.ubam.videojuegos_api.DTOs;

import org.springframework.web.multipart.MultipartFile;

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
        private MultipartFile imagenFile;
        private String trailerUrl;

    public DTOVideojuego(Boolean activo, String categorias, Integer desarrolladoresId, String descripcion, Integer esbrId, String fechaLanzamiento, MultipartFile imagenFile, String plataformas, Float precio, String requisitos, String titulo, String trailerUrl) {
        this.activo = activo;
        this.categorias = categorias;
        this.desarrolladoresId = desarrolladoresId;
        this.descripcion = descripcion;
        this.esbrId = esbrId;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagenFile = imagenFile;
        this.plataformas = plataformas;
        this.precio = precio;
        this.requisitos = requisitos;
        this.titulo = titulo;
        this.trailerUrl = trailerUrl;
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

    public MultipartFile getImagenFile() {
        return imagenFile;
    }

    public void setImagenFile(MultipartFile imagenFile) {
        this.imagenFile = imagenFile;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    


}
