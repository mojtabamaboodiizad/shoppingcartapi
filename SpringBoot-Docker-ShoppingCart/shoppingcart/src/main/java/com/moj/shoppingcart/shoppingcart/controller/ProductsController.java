package com.moj.shoppingcart.shoppingcart.controller;


import com.moj.shoppingcart.shoppingcart.model.ProductRequestModel;
import com.moj.shoppingcart.shoppingcart.model.ProductResponseModel;
import com.moj.shoppingcart.shoppingcart.service.ProductService;
import com.moj.shoppingcart.shoppingcart.model.ProductUpdateModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService service;
    //add products
    @PostMapping
    public ResponseEntity<ProductResponseModel> addProduct(@RequestBody ProductRequestModel entry){
        this.service.addProduct(entry);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProductResponseModel dto = modelMapper.map(entry, ProductResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping(value = ("/{productID}"))
    public ResponseEntity<ProductResponseModel> getProductById(@PathVariable("productID") Long id){
        ProductResponseModel res = this.service.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<String> deleteProducts(@PathVariable("productID") long id){
        String message = service.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);

    }

    @PutMapping(value ="/{productID}" )
    public ResponseEntity<ProductResponseModel> updateProducts(@PathVariable("productID") long id , @Valid @RequestBody ProductUpdateModel updated)
    {
       ProductResponseModel res = service.editProduct(id,updated);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}