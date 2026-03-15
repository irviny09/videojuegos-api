package com.ubam.videojuegos_api.services.interfaces;

import java.util.List;
import java.util.Map;

import com.ubam.videojuegos_api.DTOs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IVideojuegoService {
    List<Map<String, Object>> mostrarVideojuegos();
    List<Map<String, Object>> mostrarMultimedia();
    ResponseEntity<?> agregarVideojuego(DTOVideojuego dtoVideojuego);
    String subirMultimedia(Integer id, MultipartFile imagenFile, String trailerUrl, String demoUrl);
    String eliminarVideojuego(Integer id);
    List<EsbrDTO> getEsbr();
    List<CategoriaDTO> getCategorias();
    List<PlataformasDTO> getPlataformas();
    List<DesarrolladoresDTO> getDesarrolladores();

}
