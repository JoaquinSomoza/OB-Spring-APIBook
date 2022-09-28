package com.example.obrestordenadores.entities;

import javax.persistence.*;

@Entity

@Table(name="laptops")
public class Laptop {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String creator;
    private Double price;
    private Integer size;
    private Boolean stock;

    // Constructores
    public Laptop(){

    }

    public Laptop(Long id, String model, String creator, Double price, Integer size, Boolean stock) {
        this.id = id;
        this.model = model;
        this.creator = creator;
        this.price = price;
        this.size = size;
        this.stock = stock;
    }
    // Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }
}
