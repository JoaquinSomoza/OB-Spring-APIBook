package com.example.obrestordenadores.controller;

import com.example.obrestordenadores.entities.Laptop;
import com.example.obrestordenadores.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    // atributo
    private LaptopRepository laptopRepository;
    // constructor
    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    // CRUD sobre la entidad de Laptop
    // Devuelve lista de objetos Laptop
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }
}


// Ejercicio 3
// Crear un método en LaptopController que reciba un objeto Laptop enviado en
// formato JSON desde Postman y persistirlo en la base de datos.

// Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.