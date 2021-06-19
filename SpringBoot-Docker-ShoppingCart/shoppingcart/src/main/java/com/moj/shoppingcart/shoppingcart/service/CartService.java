package com.moj.shoppingcart.shoppingcart.service;

import com.moj.shoppingcart.shoppingcart.data.CartProductDto;
import com.moj.shoppingcart.shoppingcart.model.CartResponseModel;
import com.moj.shoppingcart.shoppingcart.model.CartUpdateRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
public interface CartService {
    
    CartResponseModel create(@NotNull(message = "Cart must contain products") @Valid List<CartProductDto> cartProductDtoList);
    
    void update(@NotNull(message = "Cart must contain products") @Valid CartUpdateRequest cart, Long id);

    List<CartResponseModel> getAllCarts();
}