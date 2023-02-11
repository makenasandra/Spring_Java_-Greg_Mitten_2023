package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
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

    @PostMapping("/meal-many-to-one")
    public ResponseEntity<Meal> mealManyToOne() {
        Meal meal = new Meal("Xiaolongbao", "Soup dumplings", 10.0);
        Ingredient ingredient = new Ingredient("Dumpling", true, true, false, true);

        ingredient.setMeal(meal);

        meal.setIngredients(Arrays.asList(ingredient));

        mealService.addMeal(meal);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        mealService.test();
        return ResponseEntity.ok("test");
    }

}
