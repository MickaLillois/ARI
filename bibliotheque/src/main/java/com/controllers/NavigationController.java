package com.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {

    @GetMapping({"/","home"})
    public String home() {
        return "home";
    }
    
    @GetMapping({"/admin/panel"})
    public String admin() {
        return "admin";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @GetMapping("/menu_livre")
    public String menu_livre() {
        return "menu_livre";
    }
    
    @GetMapping("/menu_lecteur")
    public String menu_lecteur() {
        return "menu_lecteur";
    }
    
    @GetMapping("/menu_auteur")
    public String menu_auteur() {
        return "menu_auteur";
    }
    
    @GetMapping("/addLecteur")
    public String addLecteur() {
        return "addLecteur";
    }
    
    @GetMapping("/addAuteur")
    public String addAuteur() {
        return "addAuteur";
    }
    
    @GetMapping("/login")
    public String login() {
    	return "login"; 
    }
	
}
