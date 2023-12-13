package com.example.aprovechapp.controller;

import com.example.aprovechapp.entity.Verduleria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientesController {
//    @Autowired
//    Verduleria verduleria;
  //TODO seguir con ello
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    @GetMapping("/home")
    public String homepage(){
        return "index.html";
    }
    @GetMapping("/quienes-somos")
    public String quienesSomos(){
        return "quienes-somos.html";
    }
}
