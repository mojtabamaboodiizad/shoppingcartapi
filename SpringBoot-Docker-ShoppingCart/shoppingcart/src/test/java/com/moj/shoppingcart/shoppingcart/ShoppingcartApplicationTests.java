package com.moj.shoppingcart.shoppingcart;

import com.moj.shoppingcart.shoppingcart.data.Product;
import com.moj.shoppingcart.shoppingcart.model.ProductRequestModel;
import com.moj.shoppingcart.shoppingcart.model.ProductResponseModel;
import com.moj.shoppingcart.shoppingcart.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)   //specify spring extension class
@SpringBootTest    //tell spring to load the application context
@AutoConfigureMockMvc //create and autoConfig Mock MVC
class ShoppingcartApplicationTests {
    @MockBean
    private ProductService service;   //Create a mock version of the product service
    @Autowired
    private MockMvc mockMvc;    //Autowire Mock MVC instance into the test class


    @Test
    @DisplayName("GET /products/1  - Found")
    void testGetProductById() throws Exception {

        Product mockProduct = new Product((long) 1, "product_desc", "product_cate", (long) 2000, LocalDate.now(), LocalDate.now());
        ProductResponseModel product = new ProductResponseModel("product_desc", "product_cate", (long) 2000, LocalDate.now(), LocalDate.now());

        doReturn(product).when(service).getProductById((long) 1);
        //exec get request
        mockMvc.perform(get("/products/{productID}", 1))

                //validate returned fields
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("product_desc")))
                .andExpect(jsonPath("$.category", is("product_cate")))
                .andExpect(jsonPath("$.price", is(2000)));
    }

    @Test
    @DisplayName("POST  /products  - Success")
    void testPostProduct() throws Exception {
        //Setup our mocked service
        ProductRequestModel postProduct = new ProductRequestModel("product_desc2", "product_cate", 2500, LocalDate.now(), LocalDate.now());
        Product responseProduct = new Product((long) 1, "product_desc2", "product_cate", 2500, LocalDate.now(), LocalDate.now());
        // doReturn(responseProduct).when(service).addProduct(postProduct);
        //exec get request
        mockMvc.perform(post("/products"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description", is("product_desc")))
                .andExpect(jsonPath("$.category", is("product_cate")))
                .andExpect(jsonPath("$.price", is(2500)));

    }
}
