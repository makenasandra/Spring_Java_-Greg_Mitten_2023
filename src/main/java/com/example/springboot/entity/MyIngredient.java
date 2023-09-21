package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class MyIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean isVegetarian;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isLactoseFree;

    public MyIngredient(Long id, String name, boolean isVegetarian, boolean isVegan, boolean isGlutenFree, boolean isLactoseFree){
       this.id = id;
       this.name = name;
       this.isLactoseFree = isLactoseFree;
       this.isGlutenFree = isGlutenFree;
       this.isVegetarian = isVegetarian;
       this.isVegan = isVegan;
    }
    public MyIngredient(){

    }
}
