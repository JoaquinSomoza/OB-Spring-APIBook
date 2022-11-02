package com.example.obrestordenadores.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;




    @GetMapping("/api/hola")
    public String saludo(){
        System.out.println(message);
        return "Hola Mundo!";
    }


    // Sirve para comprobar roles de seguridad.
    @GetMapping("/api/bootstrap")
    public String bootstrap(){
        //Con 3 comillas podes introducir un bloque de String
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola mundo desde Spring Boot!</h1>
                    <a class="btn btn-primary" href="https://www.google.com">Google</a>
                   <!-- Option 1: Bootstrap Bundle with Popper -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
                
                    <!-- Option 2: Separate Popper and Bootstrap JS -->
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
                  
                  </body>
                </html>
                
                """;
    }
}

// Ejercicio 1. Sesiones 4, 5 y 6.
//Crear una clase HelloController que sea un controlador REST.
// Dentro de la clase crear un método que retorne un saludo.
// Probar que retorna el saludo desde el navegador y desde Postman.