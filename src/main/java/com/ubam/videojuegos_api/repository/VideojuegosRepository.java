package com.ubam.videojuegos_api.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ubam.videojuegos_api.models.Videojuegos;

import jakarta.transaction.Transactional;


public interface VideojuegosRepository extends JpaRepository<Videojuegos, Integer> {
    
    @Query(value = "call sp_showAllGames()", nativeQuery = true)
    List<Map<String, Object>> showAllGames();

    @Transactional
    @Procedure(name = "sp_createNewGame")
    void sp_createNewGame(
        @Param("_titulo") String titulo,
        @Param("_desarrolladoresId") int desarrolladoresId,
        @Param("_fechaLanzamiento") Date fechaLanzamiento,
        @Param("_descripcion") String descripcion,
        @Param("_esbrId") int esbId,
        @Param("_precio") float precio,
        @Param("_requisitos") String requisitos,
        @Param("_activo") boolean activo,
        @Param("_categorias") String categorias,
        @Param("_plataformas") String plataformas,
        @Param("_imagenUrl") String imagenUrl,
        @Param("_trailerUrl") String trailerUrl
    );
}
