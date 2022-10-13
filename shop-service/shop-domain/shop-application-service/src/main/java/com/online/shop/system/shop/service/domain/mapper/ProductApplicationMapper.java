package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.UpdateProduct;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import org.springframework.stereotype.Component;

@Component
public class ProductApplicationMapper {

    public Product createProductToProduct(CreateProduct createProduct) {
        return Product.builder()
                .name(createProduct.getName())
                .price(new Money(createProduct.getPrice()))
                .quantity(createProduct.getQuantity())
                .description(createProduct.getDescription())
                .build();
    }

    public Product updateProductToProduct(UpdateProduct updateProduct){
        return Product.builder()
                .productID(new ProductID(updateProduct.getId()))
                .name(updateProduct.getName())
                .price(new Money(updateProduct.getPrice()))
                .description(updateProduct.getDescription())
                .quantity(updateProduct.getQuantity())
                .status(updateProduct.getStatus())
                .build();
    }

    public GetProductResponse productToGetProductResponse(Product product){
        return GetProductResponse.builder()
                .productID(product.getId().getValue())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().getAmount())
                .quantity(product.getQuantity())
                .rating(product.getRating())
                .images(product.getImages())
                .status(product.getStatus())
                .build();
    }
}
