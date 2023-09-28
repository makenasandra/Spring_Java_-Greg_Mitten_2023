package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/meal")


public class MealController {
    private MealService mealService;
    private final static Logger logger = LoggerFactory.getLogger(MealController.class);
    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        logger.info("Request received to get all meals");
        List<Meal> meals = mealService.getMeals();
        meals = null;
        if(meals == null){
            logger.error("Found null meals");
            return ResponseEntity.internalServerError().build();
        } else if (meals.isEmpty()) {
            logger.warn("No meals found");

        }
        return ResponseEntity.ok(meals);
    }

    @PutMapping("/meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/meal")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals() {
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
        return ResponseEntity.ok("2 + 2 = 4");
    }

}
