package com.moj.shoppingcart.shoppingcart.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotEmpty(message = "Category is mandatory")
    private String category;

    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate updated;

    public Product() {
    }

    public Product(Long id, String description, String category, double price, LocalDate created, LocalDate updated) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.price = price;
        this.created = created;
        this.updated = updated;
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
