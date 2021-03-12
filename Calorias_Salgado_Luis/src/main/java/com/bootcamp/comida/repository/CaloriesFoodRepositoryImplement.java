package com.bootcamp.comida.repository;

import com.bootcamp.comida.dto.CaloriesDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;


@Repository
public class CaloriesFoodRepositoryImplement implements ICaloriesFoodRepository {


    @Override
    public CaloriesDto findCalories(String name) {
        List<CaloriesDto> calories = null;
        calories = load();
        CaloriesDto result = null;

        if(calories != null){
            Optional<CaloriesDto> item = calories.stream()
                    .filter(caloriesDto -> caloriesDto.getName().equals(name)).findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }

    private List<CaloriesDto> load(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }catch(Exception e){
            e.getStackTrace();
        }

        ObjectMapper oB = new ObjectMapper();
        TypeReference<List<CaloriesDto>> typeRef = new TypeReference<>() {};
        List<CaloriesDto> caloriesDtos = null;
        try{
            caloriesDtos = oB.readValue(file, typeRef);
        }catch (Exception e){
            e.getStackTrace();
        }

        return caloriesDtos;
    }
}
