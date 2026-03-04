package com.ubam.videojuegos_api.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.DTOs.DTOVideojuego;



@RestController
@RequestMapping("/api")
public class ApiController {
    

    @Autowired
    private com.ubam.videojuegos_api.services.implementations.VideojuegoService VideojuegoService;

    @GetMapping("/mostrar-videojuegos")
    public List<Map<String, Object>> mostrarVideojuegos() {
        return VideojuegoService.mostrarVideojuegos();
    }

    @PostMapping("/agregar-videojuego")
    public String agregarVideojuego(@RequestBody DTOVideojuego juegoDTO) {
        try {
            VideojuegoService.agregarVideojuego(juegoDTO);
            return "Videojuego Agregado Correctamente";
        } catch (Exception e) {
            
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @PostMapping("/subir-multimedia")
    public String subirMultimedia(
        @RequestParam("id") Integer id, 
        @RequestParam("imagenFile") MultipartFile imagenFile,
        @RequestParam("trailerUrl") String trailerUrl
    ) {
        try {
            VideojuegoService.subirMultimedia(id, imagenFile, trailerUrl);
            return "Multimedia vinculada correctamente al juego #" + id;
        } catch (Exception e) {
            return "Error al subir multimedia: " + e.getMessage();
        }
    }

    @PostMapping("/eliminar-videojuego")
    public String eliminarVideojuego(@RequestBody int id) {
        try {
            VideojuegoService.eliminarVideojuego(id);
            return "Videojuego Eliminado Exitosamente";
        } catch (Exception e) {
            return "Error";
        }
    }
}
