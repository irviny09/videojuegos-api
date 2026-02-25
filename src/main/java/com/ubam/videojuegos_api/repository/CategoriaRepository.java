package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
