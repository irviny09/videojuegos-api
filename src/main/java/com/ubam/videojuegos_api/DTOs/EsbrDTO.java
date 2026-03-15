package com.ubam.videojuegos_api.DTOs;

public class EsbrDTO {
    private Integer id;
    private String name;

    public EsbrDTO() {
    }

    public EsbrDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
