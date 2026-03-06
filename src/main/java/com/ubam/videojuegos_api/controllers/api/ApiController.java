package com.ubam.videojuegos_api.controllers.api;

import java.util.List;
import java.util.Map;

import com.ubam.videojuegos_api.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiController {
    

    @Autowired
    private com.ubam.videojuegos_api.services.implementations.VideojuegoService VideojuegoService;

    @GetMapping("/mostrar-videojuegos")
    public List<Map<String, Object>> mostrarVideojuegos() {
        return VideojuegoService.mostrarVideojuegos();
    }

    @GetMapping("/mostrar-imagenes")
    public List<Map<String, Object>> mostrarImagenes(){

        return VideojuegoService.mostrarMultimedia();
    }

    @PostMapping("/agregar-videojuego")
    public ResponseEntity<?> agregarVideojuego(@RequestBody DTOVideojuego juegoDTO) {
        try {
            return VideojuegoService.agregarVideojuego(juegoDTO);
        } catch (Exception e) {
            
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @PostMapping("/subir-multimedia")
    public String subirMultimedia(
        @RequestParam("id") Integer id, 
        @RequestParam("imagenFile") MultipartFile imagenFile,
        @RequestParam("trailerUrl") String trailerUrl,
        @RequestParam("demoUrl") String demoUrl
    ) {
        try {
            VideojuegoService.subirMultimedia(id, imagenFile, trailerUrl, demoUrl);
            return "Multimedia vinculada correctamente al juego #" + id;
        } catch (Exception e) {
            return "Error al subir multimedia: " + e.getMessage();
        }
    }

    @PostMapping("/eliminar-videojuego")
    public String eliminarVideojuego(@RequestParam int id) {
        try {
            VideojuegoService.eliminarVideojuego(id);
            return "Videojuego Eliminado Exitosamente";
        } catch (Exception e) {
            return "Error";
        }
    }

    @GetMapping("/mostrar-categorias")
    public List<CategoriaDTO> mostrarCategorias(){
        return VideojuegoService.getCategorias();
    }

    @GetMapping("/mostrar-esbr")
    public List<EsbrDTO> mostrarEsbr(){
        return VideojuegoService.getEsbr();
    }

    @GetMapping("/mostrar-plataformas")
    public List<PlataformasDTO> mostrarPlataformas(){
        return VideojuegoService.getPlataformas();
    }

    @GetMapping("/mostrar-desarrolladores")
    public List<DesarrolladoresDTO> mostrarDesarrolladores(){
        return VideojuegoService.getDesarrolladores();
    }


}
