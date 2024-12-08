package com.foodapp.springapp.repository;

import com.foodapp.springapp.entity.Meals;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeelsRepository extends JpaRepository<Meals, String> {
	
	//Custom Query 
	@Query("SELECT m FROM Meals m WHERE m.name = :name AND m.price = :price")
	public Meals findByNameAndPrice(@Param(value = "name") String name, @Param(value = "price") String price);

}
