package com.lukashevich.shop.model;

import java.util.Date;

public abstract class BaseModel {
    private Long id;
    private Date dateOfAdding;

    public BaseModel() {
    }

    public BaseModel(Long id, Date dateOfAdding) {
        this.id = id;
        this.dateOfAdding = dateOfAdding;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(Date dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }
}
