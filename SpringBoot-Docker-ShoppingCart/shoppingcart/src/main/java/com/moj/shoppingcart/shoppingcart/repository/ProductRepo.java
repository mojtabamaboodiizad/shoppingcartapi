package com.moj.shoppingcart.shoppingcart.repository;

import com.moj.shoppingcart.shoppingcart.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product ",nativeQuery = true)
    List<Product> nativeGetAllProducts();

    @Query(value = "SELECT u  FROM Product u WHERE u.id = :id")
    Product nativeGetProductByID(@Param(value = "id") long id);

    @Modifying
    @Query(value = "DELETE FROM  Product u  WHERE u.id = :id")
    void nativeDeleteProduct(@Param(value = "id") long id);

    @Modifying
    @Query(value = "INSERT INTO product(description,category,price,created,updated) VALUES(:description,:category,:price,:created,:updated)" ,nativeQuery = true)
    void nativeInset(

            @Param(value = "description") String description,
            @Param(value = "category") String category,
            @Param(value = "price") double price,
            @Param(value = "created") LocalDate created,
            @Param(value = "updated") LocalDate updated
    );

}