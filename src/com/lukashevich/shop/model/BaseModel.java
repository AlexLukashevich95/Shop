package com.lukashevich.shop.model;

import java.util.Date;

public abstract class BaseModel {
    private Long id;
    private String name;
    private Date dateOfAdding;

    public BaseModel(Long id, String name, Date dateOfAdding) {
        this.id = id;
        this.name = name;
        this.dateOfAdding = dateOfAdding;
    }

    public BaseModel() {
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

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(Date dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }
}
