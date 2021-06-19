package com.moj.shoppingcart.shoppingcart.model;

import com.moj.shoppingcart.shoppingcart.data.CartProductDto;

import java.util.ArrayList;
import java.util.List;

public class CartRequestModel {

    private List<CartProductDto> cartItems = new ArrayList<>();

    public CartRequestModel(List<CartProductDto> cartItems) {
        this.cartItems = cartItems;
    }

    public CartRequestModel() {
    }

    public List<CartProductDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartProductDto> cartItems) {
        this.cartItems = cartItems;
    }


}
