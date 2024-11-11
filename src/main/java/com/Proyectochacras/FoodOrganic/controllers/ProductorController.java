package com.Proyectochacras.FoodOrganic.controllers;

import com.Proyectochacras.FoodOrganic.models.Productor;
import com.Proyectochacras.FoodOrganic.service.ProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductorController {

    @Autowired
    private ProductorService productorService;

    // Endpoint para obtener todos los productores
    @GetMapping("/api/productores")
    public List<Productor> obtenerTodosLosProductores() {
        return productorService.obtenerTodosLosProductores(); // Devuelve todos los productores
    }
}
