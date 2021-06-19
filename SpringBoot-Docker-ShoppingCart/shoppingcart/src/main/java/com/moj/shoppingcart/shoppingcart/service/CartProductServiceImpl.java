package com.moj.shoppingcart.shoppingcart.service;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import com.moj.shoppingcart.shoppingcart.repository.CartProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class CartProductServiceImpl implements CartProductService {

  private CartProductRepo repo;

  @Autowired
  public CartProductServiceImpl(CartProductRepo cartProductRepo) {
    this.repo = cartProductRepo;
  }

  @Override
  public CartProduct create(@NotNull(message = "Cart must contain products") @Valid CartProduct cartProduct) {
   
    return this.repo.save(cartProduct);
  }


    


   

}