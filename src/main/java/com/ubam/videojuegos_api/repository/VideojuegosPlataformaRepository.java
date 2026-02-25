package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.VideojuegosPlataforma;

public interface VideojuegosPlataformaRepository extends JpaRepository<VideojuegosPlataforma, Integer> {
    
}
