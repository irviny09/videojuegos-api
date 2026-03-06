package com.ubam.videojuegos_api.services.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.*;

import com.ubam.videojuegos_api.DTOs.*;
import com.ubam.videojuegos_api.models.Categoria;
import com.ubam.videojuegos_api.models.Desarrolladores;
import com.ubam.videojuegos_api.models.Esbr;
import com.ubam.videojuegos_api.models.Plataformas;
import com.ubam.videojuegos_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ubam.videojuegos_api.services.interfaces.IVideojuegoService;

import jakarta.transaction.Transactional;

@Service
public class VideojuegoService implements IVideojuegoService {

    @Autowired
    private VideojuegosRepository videojuegosRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EsbrRepository esbrRepository;
    @Autowired
    private PlataformasRepository plataformasRepository;
    @Autowired
    private DesarrolladoresRepository desarrolladoresRepository;

    @Override
    public List<Map<String, Object>> mostrarVideojuegos() {
        return videojuegosRepository.showAllGames();
    }

    @Override
    public List<Map<String, Object>> mostrarMultimedia() {
        List<Map<String, Object>> listaImagenes = videojuegosRepository.showMultimedia();

        for (Map<String, Object> item : listaImagenes) {
            try {
                String nombreArchivo = (String) item.get("Multimedia_ImagenURL");
                ClassPathResource imgFile = new ClassPathResource("static/uploads/" + nombreArchivo);

                if (imgFile.exists()) {
                    byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
                    String base64 = Base64.getEncoder().encodeToString(bytes);
                    item.put("imagen_base64", base64);
                } else {
                    item.put("imagen_base64", null);
                }
            } catch (IOException e) {
                item.put("imagen_base64", null);
            }
        }
        return listaImagenes;
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
                    juegoDTO.getPlataformas(),
                    juegoDTO.getStock());

            Map<String, Object> response = new HashMap<>();
            response.put("id", nuevoId);
            response.put("mensaje", "Registrado con éxito");
            return ResponseEntity.ok(response);
            } catch (Exception e) {
                Map<String, Object> errorMap = new HashMap<>();
                errorMap.put("mensaje", "Error en el servidor");
                errorMap.put("detalle", e.getMessage());
                return ResponseEntity.internalServerError().body(errorMap);
            }
    }

    @Override
    public String subirMultimedia(
            Integer id,
            MultipartFile imagenFile,
            String trailerUrl,
            String demoUrl) {
        try {
            if (imagenFile.isEmpty())
                return "Error: Archivo vacío";

            String rutaCarpeta = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists())
                carpeta.mkdirs();

            String extension = imagenFile.getOriginalFilename()
                    .substring(imagenFile.getOriginalFilename().lastIndexOf("."));
            String nombreArchivo = System.currentTimeMillis() + "-img" + extension;

            Path rutaCompleta = Paths.get(rutaCarpeta + nombreArchivo);
            Files.write(rutaCompleta, imagenFile.getBytes());

            String urlImagen = "/uploads/" + nombreArchivo;
            videojuegosRepository.sp_updateGame_Multimedia(id, urlImagen, trailerUrl, demoUrl);

            return "Multimedia vinculada correctamente al juego #" + id;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar multimedia" + e.getMessage());
        }
    }

    @Override
    public String eliminarVideojuego(Integer id) {
        try {
            videojuegosRepository.sp_deleteGameById(id);
            return "Videojuego Eliminado Exitosamente";
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public List<CategoriaDTO> getCategorias(){
        List<CategoriaDTO> lista = new ArrayList<>();
        try {
            Iterable<Categoria> data = categoriaRepository.findAll();
            for(var categoria : data){
                lista.add(new CategoriaDTO(
                        categoria.getId(), categoria.getNombre()
                ));
            }
        }catch (Exception e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<EsbrDTO> getEsbr(){
        List<EsbrDTO> lista = new ArrayList<>();
        try {
            Iterable<Esbr> data = esbrRepository.findAll();
            for(var esbr : data){
                lista.add(new EsbrDTO(
                        esbr.getId() , esbr.getEsbr()
                ));
            }
        }catch (Exception e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<PlataformasDTO> getPlataformas(){
        List<PlataformasDTO> lista = new ArrayList<>();
        try {
            Iterable<Plataformas> data = plataformasRepository.findAll();
            for(var plataforma : data){
                lista.add(new PlataformasDTO(
                    plataforma.getId(), plataforma.getNombre()
                ));
            }
        }catch (Exception e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<DesarrolladoresDTO> getDesarrolladores(){
        List<DesarrolladoresDTO> lista = new ArrayList<>();
        try {
            Iterable<Desarrolladores> data = desarrolladoresRepository.findAll();
            for(var desarrollador : data){
                lista.add(new DesarrolladoresDTO(
                        desarrollador.getId(), desarrollador.getNombre()
                ));
            }
        }catch (Exception e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return lista;
    }

}
