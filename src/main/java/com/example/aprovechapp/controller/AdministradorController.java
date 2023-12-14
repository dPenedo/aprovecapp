package com.example.aprovechapp.controller;

import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.exceptions.MyException;
import com.example.aprovechapp.service.impl.AdministradorServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorServiceImpl administradorServiceImpl;


    }
