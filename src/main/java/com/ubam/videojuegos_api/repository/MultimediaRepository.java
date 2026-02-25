package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.Multimedia;

public interface MultimediaRepository extends JpaRepository<Multimedia, Integer> {
    
}
