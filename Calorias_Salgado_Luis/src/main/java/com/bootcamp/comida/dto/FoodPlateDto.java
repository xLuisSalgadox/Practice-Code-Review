package com.bootcamp.comida.dto;


import java.util.List;

public class FoodPlateDto {
    String name;
    List<IngredientsDto> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientsDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDto> ingredients) {
        this.ingredients = ingredients;
    }
}
