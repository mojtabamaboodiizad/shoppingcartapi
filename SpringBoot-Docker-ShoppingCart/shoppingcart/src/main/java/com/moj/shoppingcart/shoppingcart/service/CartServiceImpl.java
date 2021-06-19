package com.moj.shoppingcart.shoppingcart.service;

import com.moj.shoppingcart.shoppingcart.data.CartProduct;
import com.moj.shoppingcart.shoppingcart.data.Product;
import com.moj.shoppingcart.shoppingcart.repository.CartRepo;
import com.moj.shoppingcart.shoppingcart.repository.ProductRepo;
import com.moj.shoppingcart.shoppingcart.data.Cart;
import com.moj.shoppingcart.shoppingcart.data.CartProductDto;
import com.moj.shoppingcart.shoppingcart.model.CartResponseModel;
import com.moj.shoppingcart.shoppingcart.model.CartUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo repo;
    @Autowired
    private CartProductService cartProductService;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public CartResponseModel create(@NotNull(message = "Cart must contain products") @Valid List<CartProductDto> list) {
        //req  contains List<DTO>
        Cart cart = new Cart();
        this.repo.save(cart);
        List<CartProduct> cartProductsList = new ArrayList<>();

        //map CartProductDTO to CartITem
        for (CartProductDto dto : list) {
            Optional<Product> product = productRepo.findById(dto.getProduct().getId());
            CartProduct cartProduct = new CartProduct(cart, product.get(), dto.getQuantity());
            cartProductsList.add(cartProductService.create(cartProduct));
        }
        cart.setCartProducts(cartProductsList);
        cart.setCreated(LocalDate.now());
        cart.setUpdated(LocalDate.now());
        //TODO
        cart.setCountryCode("US");
        //TODO
        cart.setCurrency("USD");
        this.repo.save(cart);
        return new CartResponseModel(cart.getCountryCode(), cart.getCurrency(), cart.getCartProducts(), cart.getCreated(), cart.getUpdated());
    }


    @Override
    public void update(@NotNull(message = "Cart must contain products") @Valid CartUpdateRequest updateRequest, Long id) {
        Cart cart = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        List<CartProduct> cartProductsList = cart.getCartProducts();
        //cart.getTotalPrice();
        this.repo.save(cart);
    }


    @Override
    public List<CartResponseModel> getAllCarts() {
        List<Cart> cartList = repo.findAll();
        return cartList.stream().map(b -> new CartResponseModel(
                b.getCountryCode(),
                b.getCurrency(),
                b.getCartProducts(),
                b.getCreated(),
                b.getUpdated()))
                .collect(Collectors.toList());

    }


}