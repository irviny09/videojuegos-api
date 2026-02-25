package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.Desarrolladores;

public interface DesarrolladoresRepository extends JpaRepository<Desarrolladores, Integer> {
    
}
