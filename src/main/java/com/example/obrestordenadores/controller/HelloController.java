package com.example.obrestordenadores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hola")
    public String saludo(){
        return "Hola Mundo!";
    }
}

// Ejercicio 1. Sesiones 4, 5 y 6.
//Crear una clase HelloController que sea un controlador REST.
// Dentro de la clase crear un método que retorne un saludo.
// Probar que retorna el saludo desde el navegador y desde Postman.