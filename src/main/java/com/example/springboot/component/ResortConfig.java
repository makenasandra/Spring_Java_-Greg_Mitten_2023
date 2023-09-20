package com.example.springboot.component;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResortConfig {
    private double minRoom;
    private double discount;
    private String todaySpecial;
    private String mainActivity;

    ResortConfig(){
    }
}
