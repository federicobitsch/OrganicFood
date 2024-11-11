package com.Proyectochacras.FoodOrganic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    // Ruta para mostrar el formulario de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Asegúrate de que este nombre coincida con el archivo .html
    }

    // Ruta para manejar el inicio de sesión (POST)
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Lógica de autenticación aquí
        return "redirect:/home"; // Redirigir a la página de inicio después de un login exitoso
    }

    // Ruta para mostrar el formulario de registro
    @GetMapping("/registerGet")
    public String showRegistrationForm() {
        return "registro"; // Asegúrate de que este nombre coincida con el archivo .html
    }


    // Ruta para manejar el registro (POST)
    @PostMapping("/registerPost")
    public String handleRegistration(@RequestParam String username, @RequestParam String password) {
        // Lógica de registro aquí
        return "redirect:/login"; // Redirige a la página de login después de un registro exitoso
    }
}
