package com.moj.shoppingcart.shoppingcart.controller;

import com.moj.shoppingcart.shoppingcart.service.CartService;
import com.moj.shoppingcart.shoppingcart.data.CartProductDto;
import com.moj.shoppingcart.shoppingcart.model.CartResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService service;



    @GetMapping
    public ResponseEntity<List<CartResponseModel>> getAllCart(){
        return new ResponseEntity<>(service.getAllCarts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartResponseModel> create(@RequestBody List<CartProductDto> cartProductDtoList){
        return new ResponseEntity<>(service.create(cartProductDtoList), HttpStatus.CREATED);
    }


}