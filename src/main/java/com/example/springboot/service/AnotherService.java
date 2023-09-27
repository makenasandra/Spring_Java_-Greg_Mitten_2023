package com.example.springboot.service;

import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.model.Meal;
import com.example.springboot.model.MyMeal;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotherService {
    private AnotherMealDao anotherMealDao;
    private Double MIN_SUMMER_TEMP = 20.0;

    @Autowired
    public AnotherService(AnotherMealDao anotherMealDao){
        this.anotherMealDao = anotherMealDao;
    }
    public void test() {
        anotherMealDao.findAllByPriceBetween(9.11, 11.05);
        System.out.println();
    }

    public List<MyMeal> getAllSummerMeals(){
          return anotherMealDao.findAllByIsSummerMeal(true);
    }
}
