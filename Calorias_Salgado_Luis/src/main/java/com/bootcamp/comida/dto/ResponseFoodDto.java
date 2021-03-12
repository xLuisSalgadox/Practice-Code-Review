package com.bootcamp.comida.dto;

import java.util.HashMap;
import java.util.List;

public class ResponseFoodDto {

    private Double caloriasTotales;
    private HashMap<String,Double> caloriasIngredients;
    private IngredientesDto highestIngredientCalories;

    public Double getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(Double caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }

    public HashMap<String, Double> getCaloriasIngredients() {
        return caloriasIngredients;
    }

    public void setCaloriasIngredients(HashMap<String, Double> caloriasIngredients) {
        this.caloriasIngredients = caloriasIngredients;
    }

    public IngredientesDto getHighestIngredientCalories() {
        return highestIngredientCalories;
    }

    public void setHighestIngredientCalories(IngredientesDto highstIngredientCalories) {
        this.highestIngredientCalories = highstIngredientCalories;
    }
}
