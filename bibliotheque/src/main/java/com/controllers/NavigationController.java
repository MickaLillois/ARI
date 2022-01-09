package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping({"/","home"})
    public String home() {
        return "home";
    }
    
    @GetMapping("/addLecteur")
    public String addLecteur() {
        return "addLecteur";
    }
	
}
