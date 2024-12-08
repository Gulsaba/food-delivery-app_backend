package com.foodapp.springapp.rest;

import com.foodapp.springapp.entity.Meals;
import com.foodapp.springapp.service.MealsService;

import ch.qos.logback.core.status.Status;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")

public class MealsRestResource {
    @Autowired
    MealsService mealsService;
    
    @RequestMapping("/create")
    public ResponseEntity<Meals> createMeal(@RequestBody Meals meals){
        Meals newMeal = this.mealsService.createMeal(meals);
        return new ResponseEntity<>(newMeal, HttpStatus.CREATED);
    }

    @RequestMapping("/get")
    public ResponseEntity<Meals> getMeals(){
        List<Meals> meals =  this.mealsService.getMeals();
        return new ResponseEntity(meals, HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public Meals getMealById(@PathVariable String id){
    	return this.mealsService.getMealById(id);
    }
    
    @RequestMapping("/get/{name}/{price}")
    public ResponseEntity<Meals> getMealsByNameAndPrice(@PathVariable String name, @PathVariable String price) {
    	Meals meals = mealsService.getMealsByNameAndPrice(name, price);
    	return new ResponseEntity(meals, HttpStatus.OK);
    }
}
