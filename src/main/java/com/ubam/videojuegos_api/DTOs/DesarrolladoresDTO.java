package com.ubam.videojuegos_api.DTOs;

public class DesarrolladoresDTO {
    private int id;
    private String name;

    public DesarrolladoresDTO() {
    }

    public DesarrolladoresDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
