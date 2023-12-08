package com.codegym.backend.model;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private MaterialType type;

    private Double price;
    private String unit;
    private Double quantity;

    public Material(Long id, String name, MaterialType type, Double price, String unit, Double quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Material() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
