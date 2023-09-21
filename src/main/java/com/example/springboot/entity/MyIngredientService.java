package com.example.springboot.entity;

public interface MyIngredientService {

    MyIngredient createIngredient(MyIngredient ingredient);
    MyIngredient getIngredient(long itemId);
    MyIngredient updateIngredient(MyIngredient ingredient);
    MyIngredient deleteIngredient(long itemId);

}
