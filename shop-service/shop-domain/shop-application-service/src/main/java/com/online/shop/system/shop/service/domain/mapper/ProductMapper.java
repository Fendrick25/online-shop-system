package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product createProductToProduct(CreateProduct createProduct) {
        return Product.builder()
                .name(createProduct.getName())
                .price(new Money(createProduct.getPrice()))
                .description(createProduct.getDescription())
                .build();
    }
}
