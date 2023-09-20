package com.example.springboot.controllerserviceDaostructure.service;

import com.example.springboot.controllerserviceDaostructure.dao.MyMealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyMealService {
    private MyMealDao mealDao;
    @Autowired
    MyMealService(MyMealDao mealDao){
        this.mealDao = mealDao;
    }
    public void addMeal (Meal meal){
        mealDao.addMeal(meal);
    }

    public List<Meal> getMeals() {
        return mealDao.getMeals();
    }

    public void updateMeal (Meal meal){
        mealDao.updateMeal(meal);
    }

    public void deleteMeal (String name){
        mealDao.deleteMeal(name);
    }

}
