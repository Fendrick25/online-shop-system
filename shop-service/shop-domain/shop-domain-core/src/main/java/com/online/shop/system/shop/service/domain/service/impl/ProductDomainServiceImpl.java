package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.service.ProductDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDomainServiceImpl implements ProductDomainService {
    @Override
    public Product validateProduct(Product product) {
        product.initializeProduct();
        log.info("Product with id: {} is created", product.getId().getValue());
        return product;
    }

}
