package com.codegym.man_hinh_ban_hang.model;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String createdTime;
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private Table table;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
