package com.moj.shoppingcart.shoppingcart.repository;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import com.moj.shoppingcart.shoppingcart.data.CartProductPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartProductRepo extends JpaRepository<CartProduct, CartProductPK> {

}