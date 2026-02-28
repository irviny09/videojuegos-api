package com.ubam.videojuegos_api.controllers.api;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.DTOs.DTOVideojuego;
import com.ubam.videojuegos_api.repository.VideojuegosRepository;



@RestController
@RequestMapping("/api")
public class ApiController {
    

    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @GetMapping("/mostrar-videojuegos")
    public List<Map<String, Object>> mostrarVideojuegos() {
        return videojuegosRepository.showAllGames(); 
    }

    @PostMapping("/agregar-videojuego")
    public ResponseEntity<?> agregarVideojuego(@RequestBody DTOVideojuego juegoDTO) {
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

    @PostMapping("/subir-multimedia")
    public String subirMultimedia(
        @RequestParam("id") Integer id, 
        @RequestParam("imagenFile") MultipartFile imagenFile,
        @RequestParam("trailerUrl") String trailerUrl
    ) {
        try {
            if (imagenFile.isEmpty()) return "Error: Archivo vacío";

            // 1. Guardar el archivo físicamente
            String rutaCarpeta = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            File carpeta = new File(rutaCarpeta);
            if(!carpeta.exists()) carpeta.mkdirs();

            String extension = imagenFile.getOriginalFilename().substring(imagenFile.getOriginalFilename().lastIndexOf("."));
            String nombreArchivo = System.currentTimeMillis() + "-img" + extension;
            
            Path rutaCompleta = Paths.get(rutaCarpeta + nombreArchivo);
            Files.write(rutaCompleta, imagenFile.getBytes());

            // 2. Guardar la URL en la BD
            String urlImagen = "/uploads/" + nombreArchivo;
            videojuegosRepository.sp_updateGame_Multimedia(id, urlImagen, trailerUrl);

            return "Multimedia vinculada correctamente al juego #" + id;
        } catch (Exception e) {
            return "Error al subir multimedia: " + e.getMessage();
        }
    }
}
