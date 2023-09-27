package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import com.example.springboot.model.MyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsSummerMeal(boolean isSummerMeal);

    List<Meal> findAllByPriceLessThan(double price);

    List<Meal> findAllByPriceBetween(double minPrice, double maxPrice);

    List<Meal> findAllByPriceLessThanAndAndDescription(double price, String description );

}
