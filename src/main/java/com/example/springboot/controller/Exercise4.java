package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Exercise4 {
    @GetMapping("/random")
    public ResponseEntity<?> getStatus(){
        if(new Random().nextBoolean()){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
