package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise3 {
    @GetMapping(value="/info")
    public ResponseEntity<?> getInfo(){
        return ResponseEntity.status(200).build();
    }
}
