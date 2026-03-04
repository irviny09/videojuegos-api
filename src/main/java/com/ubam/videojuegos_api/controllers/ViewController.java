package com.ubam.videojuegos_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ubam.videojuegos_api.repository.VideojuegosRepository;



@Controller
public class ViewController {
    
    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("videojuego/{id}")
    public String getMethodName(@PathVariable int id , Model model) {
        
        model.addAttribute("juego", videojuegosRepository.showGameById(id));
        return "videojuego";
    }
    
    
}
