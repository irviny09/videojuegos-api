package com.ubam.videojuegos_api.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.repository.VideojuegosRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



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
    public String agregarVideojuego(
        @RequestParam("titulo") String titulo,
        @RequestParam("desarrolladoresId") Integer desarrolladoresId,
        @RequestParam("fechaLanzamiento") String fechaLanzamientoStr,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("esbrId") Integer esbrId,
        @RequestParam("precio") Float precio,
        @RequestParam("requisitos") String requisitos,
        @RequestParam("activo") Boolean activo,
        @RequestParam("categorias") String categorias,
        @RequestParam("plataformas") String plataformas,
        @RequestParam("trailer") String trailerUrl
    ) {
        try {
            // String rutaCarpeta = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            // File carpeta = new File(rutaCarpeta);
            // if(!carpeta.exists()) carpeta.mkdir();
            // String nombreArchivo = System.currentTimeMillis() + "_" + imagenFile.getOriginalFilename();
            // Path rutaCompleta = Paths.get(rutaCarpeta + nombreArchivo);
            // Files.write(rutaCompleta, imagenFile.getBytes());
            // String urlImagen = "/uploads/" + nombreArchivo;

            Date fechaLanzamiento = Date.valueOf(fechaLanzamientoStr);
            videojuegosRepository.sp_createNewGame(titulo, desarrolladoresId, fechaLanzamiento, descripcion, esbrId, precio, requisitos, activo, categorias, plataformas, "/uploads/prueba", trailerUrl);
            return "pelicula agregada correctamente";
        } catch (Exception e) {
            return "Error al agregar videojuego: " + e.getMessage();
        }
        
    }
    
    
}
