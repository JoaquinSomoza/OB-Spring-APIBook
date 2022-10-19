package com.example.obrestordenadores.controller;

import com.example.obrestordenadores.entities.Laptop;
import com.example.obrestordenadores.repository.LaptopRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {

    // Permite mostrar mensaje en consola per a traves de Log.
    private final org.slf4j.Logger log = LoggerFactory.getLogger(LaptopController.class);



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

    // Devuelve un objeto diferenciado por su Id.
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptOpt = laptopRepository.findById(id);
        if(laptOpt.isPresent())
            return ResponseEntity.ok(laptOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    // Ejercicio 3 sessiones 4, 5 y 6 que luego se mejora
    /*@PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }*/

    // Crear una laptop que no existe aun.
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        // Se usa para ver quien esta enviando esa informacion al header
        System.out.println(headers.get("User-Agent"));
        if(laptop.getId()!=null){
            log.warn("Trying to create a laptop with id");
            System.out.println("Trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Actualiza una laptop que ya existe.
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId()==null){
            log.warn("Trying to update a non existent laptop");
            // se devuelve que la peticion esta mal realizada.
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Borrar una laptop de la base de datos.
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        // Verificar primero si existe.
        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        // Cuando se borra un contenido se devuelve un noContent().
        return ResponseEntity.noContent().build();
    }

    // Borrar TODAS las laptos de la base de datos.
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request Ejecutando Metodo Borrar Todo");
        laptopRepository.deleteAll();
        return ResponseEntity.notFound().build();
    }
}


// Ejercicio 3 Sesiones 4, 5 y 6.
// Crear un método en LaptopController que reciba un objeto Laptop enviado en
// formato JSON desde Postman y persistirlo en la base de datos.

// Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.

// Ejercicio 7
// Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.
/* Los métodos CRUD:
        findAll() *
        findOneById() *
        create() *
        update() *
        delete() *
        deleteAll()
*/