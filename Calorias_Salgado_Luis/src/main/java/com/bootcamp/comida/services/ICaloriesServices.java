package com.bootcamp.comida.services;

import com.bootcamp.comida.dto.FoodPlateDto;
import com.bootcamp.comida.dto.ResponseFoodDto;

public interface ICaloriesServices {

    ResponseFoodDto calculateFood(FoodPlateDto foodPlate);

}
