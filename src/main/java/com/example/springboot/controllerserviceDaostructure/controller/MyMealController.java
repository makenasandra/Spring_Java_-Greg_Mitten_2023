package com.example.springboot.controllerserviceDaostructure.controller;

import com.example.springboot.controllerserviceDaostructure.service.MyMealService;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-api")
public class MyMealController {
    private MyMealService myMealService;

    @Autowired
    public MyMealController(MyMealService myMealService){
        this.myMealService = myMealService;
    }

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(myMealService.getMeals());
    }

    @PostMapping("/add-meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal){
        myMealService.addMeal(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(meal);
    }

    @PutMapping("/update-meal")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal){
        myMealService.updateMeal(meal);
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    @DeleteMapping("/delete-meal/{name}")
    public ResponseEntity<Meal> addMeal(@PathVariable String name){
        myMealService.deleteMeal(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
