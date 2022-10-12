package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductImageEntity;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductDataAccessMapper {
    public Product productEntityToProduct(ProductEntity productEntity){
/*        return new Product(new ProductID(productEntity.getId()),
                productEntity.getName(),
                new Money(productEntity.getPrice()),
                productImageEntityToImage(productEntity.getProductImages()),
                productEntity.getDescription(),
                productEntity.getRating(),
                productEntity.getProductStatus(),
                productEntity.getQuantity())*/;

        return Product.builder()
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
                .productStatus(product.getStatus())
                .rating(product.getRating())
                .quantity(product.getQuantity())
                .build();
    }

    private List<byte[]> productImageEntityToImage(List<ProductImageEntity> productImageEntities){
        return productImageEntities.stream()
                .map(ProductImageEntity::getImage).collect(Collectors.toList());
    }

    public List<ProductImageEntity> multiPartFileToProductImageEntities(List<MultipartFile> images){
        return images.stream()
                .map(image -> {
                    try {
                        return ProductImageEntity.builder()
                                .id(UUID.randomUUID())
                                .name(image.getOriginalFilename())
                                .contentType(image.getContentType())
                                .size(image.getSize())
                                .image(image.getBytes())
                                .build();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }

}
