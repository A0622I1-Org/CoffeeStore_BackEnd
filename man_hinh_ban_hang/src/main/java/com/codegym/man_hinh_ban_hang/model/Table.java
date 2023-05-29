package com.codegym.man_hinh_ban_hang.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String status;
    private boolean enableFlag;
    @OneToMany(mappedBy = "bill")
    @JsonBackReference
    private Set<Bill> billSet;

    public Table() {
    }

    public Table(int id, String name, String status, boolean enableFlag) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.enableFlag = enableFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(boolean enableFlag) {
        this.enableFlag = enableFlag;
    }
}
