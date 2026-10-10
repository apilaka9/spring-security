package com.pilaka.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getMyCardsInformation(){
        return "Here are the Cards details";
    }
}
