package com.bootcamp.comida.repository;

import com.bootcamp.comida.dto.CaloriesDto;

public interface ICaloriesFoodRepository {

    CaloriesDto findCalories(String name);

}
