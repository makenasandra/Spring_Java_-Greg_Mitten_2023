package com.example.springboot.entity;

import org.springframework.stereotype.Service;

@Service
public class MyIngredientServiceImpl implements MyIngredientService{
    MyIngredientRepo ingredientRepo;
    @Override
    public MyIngredient createIngredient(MyIngredient ingredient) {
        ingredientRepo.save(ingredient);
        return ingredient;
    }
    @Override
    public MyIngredient getIngredient(long itemId) {
        return ingredientRepo.getMyIngredientById(itemId);
    }
    @Override
    public MyIngredient updateIngredient(MyIngredient ingredient) {
        ingredientRepo.save(ingredient);
        return ingredient;
    }
    @Override
    public MyIngredient deleteIngredient(long itemId) {
        MyIngredient ingredient = ingredientRepo.getMyIngredientById(itemId);
        if(ingredient == null){
            return null;
        }
        ingredientRepo.deleteById(itemId);
        return ingredient;
    }
}
