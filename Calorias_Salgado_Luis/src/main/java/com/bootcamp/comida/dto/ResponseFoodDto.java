package com.bootcamp.comida.dto;

import java.util.HashMap;

public class ResponseFoodDto {

    private Double caloriasTotales;
    private HashMap<String,Double> caloriasIngredients;
    private IngredientsDto highestIngredientCalories;

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

    public IngredientsDto getHighestIngredientCalories() {
        return highestIngredientCalories;
    }

    public void setHighestIngredientCalories(IngredientsDto highstIngredientCalories) {
        this.highestIngredientCalories = highstIngredientCalories;
    }
}
