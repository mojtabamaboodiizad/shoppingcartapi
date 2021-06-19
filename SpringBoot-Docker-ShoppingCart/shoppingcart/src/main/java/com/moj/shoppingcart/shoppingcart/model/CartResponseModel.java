package com.moj.shoppingcart.shoppingcart.model;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartResponseModel {

    private String countryCode;
    private String currency;
    private List<CartProduct> cartProducts = new ArrayList<>();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDate updated;


    public CartResponseModel(String countryCode, String currency, List<CartProduct> cartProducts, LocalDate created, LocalDate updated) {
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

