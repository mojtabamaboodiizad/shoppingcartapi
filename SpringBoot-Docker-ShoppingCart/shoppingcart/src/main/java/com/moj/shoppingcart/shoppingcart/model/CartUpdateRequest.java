package com.moj.shoppingcart.shoppingcart.model;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

public class CartUpdateRequest {
    private List<CartProduct> cartProducts = new ArrayList<>();

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

}
