package com.ubam.videojuegos_api.controllers.api;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String agregarVideojuego(@ModelAttribute DTOVideojuego juegoDTO, @RequestParam(value = "imagen", required = false) MultipartFile imagenFile) {
        try {
            String rutaCarpeta = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            File carpeta = new File(rutaCarpeta);
            if(!carpeta.exists()) carpeta.mkdir();
            String nombreArchivo = System.currentTimeMillis() + "_" + juegoDTO.getImagenFile().getOriginalFilename();
            Path rutaCompleta = Paths.get(rutaCarpeta + nombreArchivo);
            Files.write(rutaCompleta, juegoDTO.getImagenFile().getBytes());
            String urlImagen = "/uploads/" + nombreArchivo;

            Date fechaLanzamiento = Date.valueOf(juegoDTO.getFechaLanzamiento());
            videojuegosRepository.sp_createNewGame(
            juegoDTO.getTitulo(), 
            juegoDTO.getDesarrolladoresId(), 
            fechaLanzamiento, 
            juegoDTO.getDescripcion(), 
            juegoDTO.getEsbrId(), 
            juegoDTO.getPrecio(), 
            juegoDTO.getRequisitos(), 
            juegoDTO.getActivo(), 
            juegoDTO.getCategorias(), 
            juegoDTO.getPlataformas(), 
            "/hola", 
            juegoDTO.getTrailerUrl());
            return "pelicula agregada correctamente";
        } catch (Exception e) {
            return "Error al agregar videojuego: " + e.getMessage();
        }
        
    }
    
    
}
