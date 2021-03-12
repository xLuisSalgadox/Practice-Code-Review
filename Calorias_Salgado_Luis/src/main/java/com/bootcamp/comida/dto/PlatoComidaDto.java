package com.bootcamp.comida.dto;


import java.util.List;

public class PlatoComidaDto {
    String name;
    List<IngredientesDto> ingredientes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientesDto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientesDto> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
