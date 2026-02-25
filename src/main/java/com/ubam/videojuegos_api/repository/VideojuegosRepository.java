package com.ubam.videojuegos_api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ubam.videojuegos_api.models.Videojuegos;


public interface VideojuegosRepository extends JpaRepository<Videojuegos, Integer> {
    
    @Query(value = "call sp_showAllGames()", nativeQuery = true)
    List<Map<String, Object>> showAllGames();
}
