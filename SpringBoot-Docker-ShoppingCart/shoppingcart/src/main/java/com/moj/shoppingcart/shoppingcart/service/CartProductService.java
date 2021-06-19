package com.moj.shoppingcart.shoppingcart.service;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CartProductService {
      CartProduct create(@NotNull(message = "Cart must contain products") @Valid CartProduct cartProduct);
}