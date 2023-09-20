package com.example.springboot.controller;

import com.example.springboot.component.ResortConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resort")
public class ResortController {
    private ResortConfig resortConfig;
    @Autowired
    public ResortController(ResortConfig resortConfig){
       this.resortConfig = resortConfig;
    }

    @GetMapping("/resort-config")
    public ResponseEntity<ResortConfig> getResortConfig(){
        this.resortConfig.setDiscount(1.59);
        this.resortConfig.setMinRoom(2345.39);
        this.resortConfig.setMainActivity("Zip Lining");
        this.resortConfig.setTodaySpecial("Vegetable Curry");
        return ResponseEntity.ok(resortConfig);
    }

    @PostMapping("create")
    public ResponseEntity<ResortConfig> createResortConfig(@RequestBody ResortConfig resortConfig){

        return ResponseEntity.status(HttpStatus.CREATED).body(resortConfig);
    }

}
