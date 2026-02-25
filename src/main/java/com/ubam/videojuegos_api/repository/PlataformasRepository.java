package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.Plataformas;

public interface PlataformasRepository extends JpaRepository<Plataformas, Integer> {
    
}
