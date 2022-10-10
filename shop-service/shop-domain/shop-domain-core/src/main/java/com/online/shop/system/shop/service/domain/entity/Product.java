package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.AggregateRoot;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Product extends AggregateRoot<ProductID> {
    private String name;
    private Money price;
    private List<byte[]> images;
    private String description;
    private double rating;
    private boolean active;

    private int quantity;

    private List<ProductReview> productReviews;

    public Product(ProductID productID){
        super.setId(productID);
    }

    @Builder
    public Product(ProductID productID, String name, Money price, String description, int quantity) {
        super.setId(productID);
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public void initializeProduct(){
        setId(new ProductID(UUID.randomUUID()));
        rating = 0.0;
        active = true;
    }
}
