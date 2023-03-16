package com.example.finalprojectprm;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class PostRequest {
    private UUID id;

    private String name;

    private String image;

    private String description;

    private Timestamp created;
    private Timestamp updated;
    private BigDecimal price;
    private BigDecimal paid;
    private int status;

//    private User userId;


    public PostRequest() {
    }

    public PostRequest(UUID id, String name, String image, String description, Timestamp created, Timestamp updated, BigDecimal price, BigDecimal paid, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.price = price;
        this.paid = paid;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}