package com.bootcamp.comida.controller;

import com.bootcamp.comida.dto.FoodPlateDto;
import com.bootcamp.comida.dto.ResponseFoodDto;
import com.bootcamp.comida.services.ICaloriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ICaloriesServices service;

    @PostMapping(value = "/comida")
    public ResponseFoodDto responds(@RequestBody FoodPlateDto platoComida){

        return service.calculateFood(platoComida);
    }
}
