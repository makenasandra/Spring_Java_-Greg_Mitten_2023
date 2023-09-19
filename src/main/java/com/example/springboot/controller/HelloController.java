package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
	@GetMapping(value = "/good-morning")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Good morning!");
	}

//	Exercise 1
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Hello World!";
	}

	//Exercise 2
	@GetMapping(value=  "/greeting" )
	public ResponseEntity<String> greeting (){
		if(new Date().getHours() > 11){
			return ResponseEntity.status(HttpStatus.OK).body("Good Afternoon!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Good Morning!");
	}


}
