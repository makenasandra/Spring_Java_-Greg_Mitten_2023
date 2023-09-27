package com.example.springboot.dao;

import com.example.springboot.model.MyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnotherMealDao extends JpaRepository<MyMeal, Long> {
    MyMeal findByName(String name);
    MyMeal findByDescription(String description);

    List<MyMeal> findAllByPriceLessThan(double price);

    List<MyMeal> findAllByPriceBetween(double minPrice, double maxPrice);

    List<MyMeal> findAllByPriceLessThanAndAndDescription(double price, String description );

    List<MyMeal> findByIsSummerMeal (boolean isSummer);

}
