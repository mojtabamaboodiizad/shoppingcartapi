package com.moj.shoppingcart.shoppingcart.service;


import com.moj.shoppingcart.shoppingcart.data.Product;
import com.moj.shoppingcart.shoppingcart.model.ProductRequestModel;
import com.moj.shoppingcart.shoppingcart.model.ProductResponseModel;
import com.moj.shoppingcart.shoppingcart.repository.ProductRepo;
import com.moj.shoppingcart.shoppingcart.model.ProductUpdateModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(final ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductResponseModel> getAllProducts() {
        List<Product> productList = productRepo.nativeGetAllProducts();
        return productList.stream().map(b -> new ProductResponseModel(
                b.getDescription(),
                b.getCategory(),
                b.getPrice(),
                b.getCreated(),
                b.getUpdated()))
                .collect(Collectors.toList());
    }

    @Override
    public Product addProduct(@NotNull(message = "product cannot be null") ProductRequestModel entry) {
        Product product = new Product();
        product.setDescription(entry.getDescription());
        product.setCategory(entry.getCategory());
        product.setPrice(entry.getPrice());
        product.setCreated(entry.getCreated());
        product.setUpdated(entry.getUpdated());
        productRepo.nativeInset(product.getDescription(), product.getCategory(), product.getPrice(), product.getCreated(), product.getUpdated());
        return product;
    }


    @Override
    public ProductResponseModel getProductById(Long id) {
        Product product = productRepo.nativeGetProductByID(id);
        if (product == null) throw new ResourceNotFoundException();

        // Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProductResponseModel dto = modelMapper.map(product, ProductResponseModel.class);
        return dto;
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        productRepo.nativeDeleteProduct(id);
        return product.getDescription() + " have been deleted";
    }

    @Override
    public ProductResponseModel editProduct(long id, ProductUpdateModel updatedProduct) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(updatedProduct.getCategory());
        product.setPrice(updatedProduct.getPrice());
        product.setCreated(updatedProduct.getCreated());
        product.setUpdated(updatedProduct.getUpdated());
        this.productRepo.save(product);
        return new ProductResponseModel(product.getDescription(), product.getCategory(), product.getPrice(), product.getCreated(), product.getUpdated());
    }


}