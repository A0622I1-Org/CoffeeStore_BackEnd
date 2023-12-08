package com.codegym.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "material_type_master")
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public MaterialType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MaterialType() {

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
}
