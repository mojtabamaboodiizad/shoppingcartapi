package com.moj.shoppingcart.shoppingcart.repository;

import com.moj.shoppingcart.shoppingcart.data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepo extends JpaRepository<Cart,Long> {

 
}