package com.ubam.videojuegos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.videojuegos_api.models.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
