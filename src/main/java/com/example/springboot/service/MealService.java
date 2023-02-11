package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealService(MealDao mealDao, RestaurantConfig restaurantConfig) {
        this.mealDao = mealDao;
        this.restaurantConfig = restaurantConfig;
    }

    public void addMeal(Meal meal) {
        mealDao.save(meal);
    }
o
    public List<Meal> getMeals() {
        return mealDao.findAll();
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }

    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }

    public void test() {
        mealDao.findByPriceGreaterThan(11.0);
    }
}
