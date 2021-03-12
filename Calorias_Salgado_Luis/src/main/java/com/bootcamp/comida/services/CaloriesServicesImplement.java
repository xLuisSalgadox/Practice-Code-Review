package com.bootcamp.comida.services;

import com.bootcamp.comida.dto.CaloriesDto;
import com.bootcamp.comida.dto.IngredientsDto;
import com.bootcamp.comida.dto.FoodPlateDto;
import com.bootcamp.comida.dto.ResponseFoodDto;

import com.bootcamp.comida.repository.ICaloriesFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CaloriesServicesImplement implements ICaloriesServices{

    @Autowired
    private ICaloriesFoodRepository caloriesRepository;

    //print response
    @Override
    public ResponseFoodDto calculateFood(FoodPlateDto foodPlate) {
        ResponseFoodDto rF = new ResponseFoodDto();
        rF.setCaloriasTotales(caloriesTotal(foodPlate));
        rF.setCaloriasIngredients(caloriesByIngredient(foodPlate));
        rF.setHighestIngredientCalories(highCalories(foodPlate));
        return rF;
    }

    //Calculate calories of ingredients by weight
    public double calculateCalories(String name, int weight){
        CaloriesDto caloriesDto = caloriesRepository.findCalories(name);

        Double caloriesCalculated;
        Integer weigthCalories = 100;
        if(caloriesDto != null){
            caloriesCalculated =  (double) (caloriesDto.getCalories())/weigthCalories;
        }else{
            caloriesCalculated = 0d;
        }

        return caloriesCalculated*weight;
    }

    //calculate the ingredient with the most calories
    public IngredientsDto highCalories(FoodPlateDto plate){
        IngredientsDto ing = new IngredientsDto();
        Double temp = 0d;
        for(IngredientsDto i: plate.getIngredients()){
            if(temp < calculateCalories(i.getName(),i.getWeight())){
                ing = i;
                temp = calculateCalories(i.getName(),i.getWeight());
            }
        }
        return ing;
    }

    //Calculate Calories total of food plate
    public Double caloriesTotal(FoodPlateDto foodPlate){
        Double temp = 0d;
        for(IngredientsDto i: foodPlate.getIngredients()){
                temp += calculateCalories(i.getName(),i.getWeight());
        }
        return temp;
    }

    //Find calories by ingrediets
    public HashMap<String,Double> caloriesByIngredient(FoodPlateDto foodPlate){
        HashMap<String, Double> saveIngredients = new HashMap<>();
        for(IngredientsDto i: foodPlate.getIngredients()){
            saveIngredients.put(i.getName(),calculateCalories(i.getName(),i.getWeight()));
        }
        return saveIngredients;

    }
}
