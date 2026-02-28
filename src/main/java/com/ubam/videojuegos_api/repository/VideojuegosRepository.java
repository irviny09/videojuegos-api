package com.ubam.videojuegos_api.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ubam.videojuegos_api.models.Videojuegos;

import jakarta.transaction.Transactional;


public interface VideojuegosRepository extends JpaRepository<Videojuegos, Integer> {
    
    @Query(value = "call sp_showAllGames()", nativeQuery = true)
    List<Map<String, Object>> showAllGames();

    @Transactional
    @Query(value = "CALL sp_addGame_X_data(:_titulo, :_desarrolladoresId, :_fechaLanzamiento, :_descripcion, :_esbrId, :_precio, :_requisitos, :_activo, :_categorias, :_plataformas)", nativeQuery = true)
    int sp_addGame_X_data(
        @Param("_titulo") String titulo,
        @Param("_desarrolladoresId") int desarrolladoresId,
        @Param("_fechaLanzamiento") Date fechaLanzamiento,
        @Param("_descripcion") String descripcion,
        @Param("_esbrId") int esbrId,
        @Param("_precio") float precio,
        @Param("_requisitos") String requisitos,
        @Param("_activo") boolean activo,
        @Param("_categorias") String categorias,
        @Param("_plataformas") String plataformas
    );

    @Transactional
    @Modifying
    @Query(value = "CALL sp_updateMultimediaGame(:id, :url, :trailer)", nativeQuery = true)
    void sp_updateGame_Multimedia(
        @Param("id") Integer id, 
        @Param("url") String url, 
        @Param("trailer") String trailer
    );
}
