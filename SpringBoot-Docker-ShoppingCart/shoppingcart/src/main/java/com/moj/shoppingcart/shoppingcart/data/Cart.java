package com.moj.shoppingcart.shoppingcart.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "cart")
@Table(name = "cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartProducts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryCode;
    private String currency;

    @OneToMany(mappedBy = "primaryKey.cart")
    @Valid
    private List<CartProduct> cartProducts = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate updated;

    public Cart() {
    }

    public Cart(String countryCode, String currency, List<CartProduct> cartProducts, LocalDate created, LocalDate updated) {
        this.countryCode = countryCode;
        this.currency = currency;
        this.cartProducts = cartProducts;
        this.created = created;
        this.updated = updated;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
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
