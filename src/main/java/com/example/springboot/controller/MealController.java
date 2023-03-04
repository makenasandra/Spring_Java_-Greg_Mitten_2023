package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    private final static Logger logger = LoggerFactory.getLogger(MealController.class);

    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
        logger.info("Someone is trying to get the secret formula!");
        return ResponseEntity.ok("2 + 2 = 4");
    }

}
