package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise3 {
    @GetMapping(value="/info")
    public ResponseEntity<?> getInfo() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
