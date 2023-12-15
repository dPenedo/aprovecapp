package com.example.aprovechapp.controller;

import com.example.aprovechapp.entity.Administrador;
import com.example.aprovechapp.entity.Verduleria;
import com.example.aprovechapp.exceptions.MyException;
import com.example.aprovechapp.service.impl.AdministradorServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClientesController {
@Autowired
AdministradorServiceImpl administradorServiceImpl;
    @GetMapping("/")
    public String index(Model model, Authentication authentication, HttpSession session) {
        if (authentication != null && authentication.isAuthenticated()) {

            String username = authentication.getName();
            Administrador logueado = (Administrador) administradorServiceImpl.encontrarAdministradorPorMail(username);
            String nombre = logueado.getNombre();

            List<Verduleria> verdulerias = logueado.getVerdulerias();
            model.addAttribute("verdulerias", verdulerias);
            model.addAttribute("username", username);
            model.addAttribute("nombre", nombre);

            return "index-authenticated.html";
        } else {
            return "index.html";
        }
    }
//    @Secured("ROLE_ADMINISTRADOR")
//    @GetMapping("/")
//    public String inicio(HttpSession session) {
//        Administrador logueado = (Administrador) session.getAttribute("administradorsession");
//        if (logueado.getAuthorities().toString().equals("ROLE_ADMINISTRADOR")) {
//            return "redirect:/admin/dashboard";
//        }
//        return "index-authenticated.html";
//    }


    @GetMapping("/home")
    public String homepage(){
        return "index.html";
    }
    @GetMapping("/quienes-somos")
    public String quienesSomos(){
        return "quienes-somos.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
                           String password2, Model model) {
        try {
            administradorServiceImpl.registrarAdministrador(nombre, email, password, password2);
            model.addAttribute("exito", "Administrador registrado correctamente!");
            return "index-authenticated.html";
        } catch (MyException ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("nombre", nombre);
            model.addAttribute("email", email);
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña invalidos!");
        }
        return "login.html";
    }

    @PostMapping("/logincheck")
    public String loginCheck( ModelMap modelo) {
        try {
            return "redirect:/";
        } catch (Exception ex) {
            // Si la autenticación falla, muestra un mensaje de error
            modelo.put("error", "Usuario o Contraseña inválidos!");
            return "login.html";
        }
    }

}
