package com.example.obrestordenadores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


// Configuracion Swagger para la generacion de documentacion de la API REST
@Configuration
public class SwaggerConfig {
    // Anotacion para poder detectarlo como Bean
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Api rest de Laptops","1.0","http://www.google.com",
                new Contact("Joaquin","http://www.google.com","joaquin@example.com"),
                "MIT",
                "http://www.google.com", Collections.emptyList());


    }


}

//Ejercicio 2 sessiones 7. 8 y 9
//Implementar swagger sobre el API REST de Laptop:
// http://localhost:8081/swagger-ui/index.html
