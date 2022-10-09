package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.AggregateRoot;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Product extends AggregateRoot<ProductID> {
    private final String name;
    private final Money price;
    private final List<byte[]> images;
    private final String description;
    private final double rating;
    private final boolean active;
    private List<ProductReview> productReviews;

    @Builder
    public Product(ProductID productID, String  name, Money price, List<byte[]> images, String description, double rating, boolean active) {
        super.setId(productID);
        this.name = name;
        this.price = price;
        this.images = images;
        this.description = description;
        this.rating = rating;
        this.active = active;
    }



}
