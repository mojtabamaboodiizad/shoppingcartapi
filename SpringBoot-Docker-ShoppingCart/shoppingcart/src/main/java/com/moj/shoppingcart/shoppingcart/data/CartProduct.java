package com.moj.shoppingcart.shoppingcart.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "cartProduct")
public class CartProduct {


    // Cart id and Product it
    @EmbeddedId
    @JsonIgnore
    private CartProductPK primaryKey;

    @Column(nullable = false)
    private Integer quantity;

    public CartProduct(Cart cart, Product product, Integer quantity) {
        this.primaryKey = new CartProductPK();
        primaryKey.setCart(cart);
        primaryKey.setProduct(product);
        this.quantity = quantity;
    }


    public CartProduct() {
        super();
    }


    @JsonIgnore
    public CartProductPK getPk() {
        return primaryKey;
    }

    public void setPk(CartProductPK pk) {
        this.primaryKey = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Transient
    public Product getProduct() {
        return this.primaryKey.getProduct();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartProduct other = (CartProduct) obj;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }
}
