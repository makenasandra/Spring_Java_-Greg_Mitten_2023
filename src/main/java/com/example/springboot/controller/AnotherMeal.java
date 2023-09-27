package com.example.springboot.controller;

import com.example.springboot.model.MyMeal;
import com.example.springboot.service.AnotherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp-meal")
public class AnotherMeal {
    private AnotherService anotherService;
    @Autowired
    public AnotherMeal( AnotherService anotherService){
        this.anotherService = anotherService;
    }
    @GetMapping("/summer-meals")
    public ResponseEntity<List<MyMeal>> getAllSummerMeals(){
        return ResponseEntity.ok(anotherService.getAllSummerMeals());
    }

    @GetMapping("/winter-meals")
    public ResponseEntity<List<MyMeal>> getAllWinterMeals(){
        return ResponseEntity.ok(anotherService.getAllSummerMeals());
    }

}
