package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.entity.Product;


public interface ProductDomainService {
    Product validateProduct(Product product);
}
