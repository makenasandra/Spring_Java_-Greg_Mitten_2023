package com.example.springboot.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredient")
public class MyIngredientController {
    MyIngredientServiceImpl ingredientService;
    @Autowired
    public MyIngredientController(MyIngredientServiceImpl ingredientService){
        this.ingredientService = ingredientService;
    }
    @PostMapping
    public ResponseEntity<MyIngredient> create(@RequestBody MyIngredient ingredient){
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MyIngredient> get(@PathVariable long id){
        MyIngredient ingredient = ingredientService.getIngredient(id);
        return ResponseEntity.ok(ingredient);
    }
    @PutMapping("/id")
    public ResponseEntity<MyIngredient> update(@PathVariable long id, @RequestBody MyIngredient ingredient){
        ingredientService.updateIngredient(ingredient);
        return ResponseEntity.ok(ingredientService.getIngredient(id));
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }

}
