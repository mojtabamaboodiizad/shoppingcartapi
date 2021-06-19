package com.moj.shoppingcart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class ProductRequestModel {

    private Long id;
    private String description;
    private String category;
    private double price;
    private LocalDate created;
    private LocalDate updated;

    public ProductRequestModel() {
    }

    public ProductRequestModel( String description, String category, double price, LocalDate created, LocalDate updated) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ProductRequestModel{" +
                "id='" + id + '\'' +
                ", description=" + description +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }


}
