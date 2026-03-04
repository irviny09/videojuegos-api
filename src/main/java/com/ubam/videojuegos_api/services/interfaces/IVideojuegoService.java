package com.ubam.videojuegos_api.services.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.DTOs.DTOVideojuego;

public interface IVideojuegoService {
    List<Map<String, Object>> mostrarVideojuegos();
    ResponseEntity<?> agregarVideojuego(DTOVideojuego dtoVideojuego);
    String subirMultimedia(Integer id, MultipartFile imagenFile, String trailerUrl);
    String eliminarVideojuego(Integer id);
}
