package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get all meals", response = List.class)
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a specific meal by a meal Id", response = String.class)
    public ResponseEntity<?> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @GetMapping("/summer-meals")
    @ApiOperation(value = "A meal can only be served when the temp is a certain level", response = Meal.class)
    public ResponseEntity<List<Meal>> getSummerMeals() {
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
        return ResponseEntity.ok("2 + 2 = 4");
    }

}
