package com.example.springboot.model;

import com.example.springboot.entity.MyIngredient;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private double price;
    private boolean isSummerMeal;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TheIngredient> ingredients;
    public MyMeal(){};
}
