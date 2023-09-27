package com.example.springboot.service;

import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.dao.MealDao;
import com.example.springboot.model.Meal;
import com.example.springboot.model.MyMeal;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnotherService {
    private AnotherMealDao anotherMealDao;
    private MealDao mealDao;
    private Double MIN_SUMMER_TEMP = 20.0;

    @Autowired
    public AnotherService(AnotherMealDao anotherMealDao, MealDao mealDao){
        this.mealDao = mealDao;
        this.anotherMealDao = anotherMealDao;
    }
    public List<Meal> test() {
        return mealDao.findAllByPriceBetween(9.11, 11.05);
    }

    public List<MyMeal> getAllSummerMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();

        if (currentTemperatureInCentigrade < MIN_SUMMER_TEMP) return new ArrayList<>();

        return anotherMealDao.findByIsSummerMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=1.2833&longitude=36.8167&current_weather=true")
                    .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MyMeal> getAllWinterMeals(){
        if(getCurrentTemperatureInCentigrade() > MIN_SUMMER_TEMP) return new ArrayList<>();

        return anotherMealDao.findByIsSummerMeal(false);
    }
}
