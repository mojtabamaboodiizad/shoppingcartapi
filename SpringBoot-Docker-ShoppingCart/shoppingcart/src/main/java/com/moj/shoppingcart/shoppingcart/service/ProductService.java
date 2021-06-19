package com.moj.shoppingcart.shoppingcart.service;

import com.moj.shoppingcart.shoppingcart.data.Product;
import com.moj.shoppingcart.shoppingcart.model.ProductRequestModel;
import com.moj.shoppingcart.shoppingcart.model.ProductResponseModel;
import com.moj.shoppingcart.shoppingcart.model.ProductUpdateModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ProductService {
    List<ProductResponseModel> getAllProducts();

    Product addProduct(@NotNull(message = "product cannot be null") ProductRequestModel entry);
    
    ProductResponseModel getProductById(Long id);

	String deleteProduct(Long id);
	
	ProductResponseModel editProduct(long id, ProductUpdateModel updateModel);
}