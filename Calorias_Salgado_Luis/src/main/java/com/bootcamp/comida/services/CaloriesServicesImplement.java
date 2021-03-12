package com.bootcamp.comida.services;

import com.bootcamp.comida.dto.CaloriesDto;
import com.bootcamp.comida.dto.IngredientesDto;
import com.bootcamp.comida.dto.PlatoComidaDto;
import com.bootcamp.comida.dto.ResponseFoodDto;

import com.bootcamp.comida.repository.ICaloriesFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CaloriesServicesImplement implements ICaloriesServices{

    @Autowired
    private ICaloriesFoodRepository caloriesRepository;

    @Override
    public ResponseFoodDto calculateFood(PlatoComidaDto platoComida) {
        ResponseFoodDto rF = new ResponseFoodDto();
        rF.setCaloriasTotales(caloriesTotal(platoComida));
        rF.setCaloriasIngredients(caloriesByIngredient(platoComida));
        rF.setHighestIngredientCalories(highCalories(platoComida));
        return rF;
    }

    public double calculateCalories(String name, int weigth){
        CaloriesDto caloriesDto = caloriesRepository.findCalories(name);

        Double caloriesCalculated;
        Integer weigthCalories = 100;
        if(caloriesDto != null){
            caloriesCalculated =  (double) (caloriesDto.getCalories())/weigthCalories;
        }else{
            caloriesCalculated = 0d;
        }

        return caloriesCalculated*weigth;
    }

    public IngredientesDto highCalories(PlatoComidaDto plato){
        IngredientesDto ing = new IngredientesDto();
        Double temp = 0d;
        for(IngredientesDto i: plato.getIngredientes()){
            if(temp < calculateCalories(i.getName(),i.getWeight())){
                ing = i;
                temp = calculateCalories(i.getName(),i.getWeight());
            }
        }
        return ing;
    }

    public Double caloriesTotal(PlatoComidaDto platoComida){
        Double temp = 0d;
        for(IngredientesDto i: platoComida.getIngredientes()){
                temp += calculateCalories(i.getName(),i.getWeight());
        }
        return temp;
    }

    public HashMap<String,Double> caloriesByIngredient(PlatoComidaDto platoComida){
        HashMap<String, Double> guardarIngredientes = new HashMap<>();
        for(IngredientesDto i: platoComida.getIngredientes()){
            guardarIngredientes.put(i.getName(),calculateCalories(i.getName(),i.getWeight()));
        }
        return guardarIngredientes;

    }
}
