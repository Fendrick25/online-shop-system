package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductImageEntity;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product productEntityToProduct(ProductEntity productEntity){
        return Product.FullFieldBuilder()
                .productID(new ProductID(productEntity.getId()))
                .name(productEntity.getName())
                .price(new Money(productEntity.getPrice()))
                .images(productImageEntityToImage(productEntity.getProductImages()))
                .description(productEntity.getDescription())
                .rating(productEntity.getRating())
                .status(productEntity.getProductStatus())
                .quantity(productEntity.getQuantity())
                .build();
    }

    public ProductEntity productToProductEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId().getValue())
                .name(product.getName())
                .price(product.getPrice().getAmount())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .build();
    }

    private List<byte[]> productImageEntityToImage(List<ProductImageEntity> productImageEntities){
        return productImageEntities.stream()
                .map(ProductImageEntity::getData).collect(Collectors.toList());
    }
}
