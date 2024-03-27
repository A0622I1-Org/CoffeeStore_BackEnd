package com.codegym.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "cost")
    private double cost;

    // Constructors, getters, and setters

    public BillDetail() {
    }

    public BillDetail(Bill bill, Service service, int quantity, double price) {
        this.bill = bill;
        this.service = service;
        this.quantity = quantity;
        this.price = price;
    }

    public BillDetail(int id, Bill bill, Service service, int quantity, double price, double cost) {
        this.id = id;
        this.bill = bill;
        this.service = service;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
    }
// Getters and Setters


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
