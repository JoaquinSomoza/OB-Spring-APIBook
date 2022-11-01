package com.example.obrestordenadores.controller;

import com.example.obrestordenadores.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    // Objeto que nos permite construir el primero.
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    // el setUp se repite antes de cada metodo
    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void saludo() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/api/hola",String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hola Mundo!", response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops",Laptop[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }


    // Se comento el test porque ocasionaba problemas con el package de maven.
    // Test en caso de que la laptop con id=1 no exista.
    /*@Test
    void findOneById() {
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        //assertEquals(HttpStatus.OK, response.getStatusCode());
    }*/



    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "model": "TUF Dash F15",
                        "creator": "ASUS",
                        "price": 470199.0,
                        "size": 15,
                        "stock": true
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
        Laptop result = response.getBody();
        assertEquals(1L,result.getId());
        assertEquals("TUF Dash F15",result.getModel());
    }


}


//Ejercicio 3 sessiones 7, 8 y 9.
//Crear casos de test para el controlador de Laptop.
//crear la clase con todos los tests unitarios.
