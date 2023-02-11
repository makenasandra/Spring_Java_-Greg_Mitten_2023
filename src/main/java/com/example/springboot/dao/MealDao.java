package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByPriceGreaterThan(double price);
    List<Meal> findByName(String name);
    List<Meal> findByDescription(String description);
}
