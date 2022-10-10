package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository {
    void createProduct(Product product);
    Product getProduct(UUID productID);
}
