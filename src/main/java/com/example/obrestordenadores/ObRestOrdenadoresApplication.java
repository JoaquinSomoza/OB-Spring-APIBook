package com.example.obrestordenadores;

import com.example.obrestordenadores.entities.Laptop;
import com.example.obrestordenadores.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//averiguar que es ENABLEWEBMVC
@EnableWebMvc
@SpringBootApplication
public class ObRestOrdenadoresApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestOrdenadoresApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD

		// crear una laptop
		Laptop laptop1 = new Laptop(null,"TUF Dash F15","ASUS",470199.0,15,true);
		Laptop laptop2 = new Laptop(null,"ROG Zephyrus G14","ASUS",250000.0,14,true);

		// almacenar una laptop

		System.out.println("Num de laptops en BD: "+ repository.findAll().size());

		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("Num de laptops en BD: "+ repository.findAll().size());

	}
}

//Ejercicio 2 session 4, 5 y 6.

//	Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":
//		Laptop (entidad)
//		LaptopRepository (repositorio)
//		LaptopController (controlador)
//		Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
//		Probar que funciona desde Postman.
//		Los objetos Laptop se pueden insertar desde el método
//		main de la clase principal.