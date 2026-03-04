package com.ubam.videojuegos_api.services.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.DTOs.DTOVideojuego;
import com.ubam.videojuegos_api.repository.VideojuegosRepository;
import com.ubam.videojuegos_api.services.interfaces.IVideojuegoService;

import jakarta.transaction.Transactional;

@Service
public class VideojuegoService implements IVideojuegoService{
    
    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @Override
    public List<Map<String, Object>> mostrarVideojuegos(){
        return videojuegosRepository.showAllGames();
    }
    
    @Transactional
    @Override
    public ResponseEntity<?> agregarVideojuego(DTOVideojuego juegoDTO) {
        try {
            Date fecha = Date.valueOf(juegoDTO.getFechaLanzamiento());
            
            Integer nuevoId = videojuegosRepository.sp_addGame_X_data(
                juegoDTO.getTitulo(),
                juegoDTO.getDesarrolladoresId(),
                fecha,
                juegoDTO.getDescripcion(),
                juegoDTO.getEsbrId(),
                juegoDTO.getPrecio(),
                juegoDTO.getRequisitos(),
                juegoDTO.getActivo(),
                juegoDTO.getCategorias(),
                juegoDTO.getPlataformas()
            );

            Map<String, Object> response = new HashMap<>();
            response.put("id", nuevoId);
            response.put("mensaje", "Registrado con éxito");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @Override
    public String subirMultimedia(
        Integer id, 
        MultipartFile imagenFile,
        String trailerUrl
    ) {
        try {
            if (imagenFile.isEmpty()) return "Error: Archivo vacío";

            String rutaCarpeta = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            File carpeta = new File(rutaCarpeta);
            if(!carpeta.exists()) carpeta.mkdirs();

            String extension = imagenFile.getOriginalFilename().substring(imagenFile.getOriginalFilename().lastIndexOf("."));
            String nombreArchivo = System.currentTimeMillis() + "-img" + extension;
            
            Path rutaCompleta = Paths.get(rutaCarpeta + nombreArchivo);
            Files.write(rutaCompleta, imagenFile.getBytes());

            String urlImagen = "/uploads/" + nombreArchivo;
            videojuegosRepository.sp_updateGame_Multimedia(id, urlImagen, trailerUrl);

            return "Multimedia vinculada correctamente al juego #" + id;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar multimedia" + e.getMessage());
        }
    }

    @Override
    public String eliminarVideojuego(Integer id){
        try {
            videojuegosRepository.sp_deleteGameById(id);
            return "Videojuego Eliminado Exitosamente";
        } catch (Exception e) {
            return "Error";
        }
    }

}
