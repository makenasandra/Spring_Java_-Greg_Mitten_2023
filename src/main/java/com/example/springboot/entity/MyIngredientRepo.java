package com.example.springboot.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyIngredientRepo extends JpaRepository<MyIngredient, Long> {
    MyIngredient getMyIngredientById(Long id);
}
