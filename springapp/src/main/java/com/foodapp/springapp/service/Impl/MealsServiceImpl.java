package com.foodapp.springapp.service.Impl;

import com.foodapp.springapp.entity.Meals;
import com.foodapp.springapp.repository.MeelsRepository;
import com.foodapp.springapp.service.MealsService;

import Exceptions.NoSuchMealExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mealsService")
public class MealsServiceImpl implements MealsService {
    @Autowired
    MeelsRepository meelsRepository;
    
	@Override
    public Meals createMeal(Meals meal) {
        Meals meals = meelsRepository.save(meal);
        return meals;
    }

	@Override
    public List<Meals> getMeals(){
        List<Meals> meals = meelsRepository.findAll();
        return meals;
    }

	@Override
	public Meals getMealById(String id) {
		Meals meal = meelsRepository.findById(id).orElse(null);
		if(meal == null) {
			 throw new NoSuchMealExistException("No such meal exist with id "+id);
		} else {
			return meal;
		}
	}

	@Override
	public Meals getMealsByNameAndPrice(String name, String price) {
		Meals meals = meelsRepository.findByNameAndPrice(name, price);
		return meals;
	}
	
}
