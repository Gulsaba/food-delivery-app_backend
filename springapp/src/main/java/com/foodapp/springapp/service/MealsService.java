package com.foodapp.springapp.service;

import com.foodapp.springapp.entity.Meals;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MealsService {
	
    Meals createMeal(Meals meal);
    
    List<Meals> getMeals ();
    
    Meals getMealById(String id);
    
    Meals getMealsByNameAndPrice(String name, String price);
}
