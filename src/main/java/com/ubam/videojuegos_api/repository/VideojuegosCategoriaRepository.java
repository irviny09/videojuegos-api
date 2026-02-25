package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.VideojuegosCategoria;

public interface VideojuegosCategoriaRepository extends JpaRepository<VideojuegosCategoria, Integer> {
    
}
