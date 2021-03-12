package com.bootcamp.comida.services;

import com.bootcamp.comida.dto.PlatoComidaDto;
import com.bootcamp.comida.dto.ResponseFoodDto;

public interface ICaloriesServices {

    ResponseFoodDto calculateFood(PlatoComidaDto platoComida);

}
