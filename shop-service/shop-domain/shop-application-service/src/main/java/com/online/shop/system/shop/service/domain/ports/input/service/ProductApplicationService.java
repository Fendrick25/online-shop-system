package com.online.shop.system.shop.service.domain.ports.input.service;


import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.response.CreateProductResponse;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;

import java.util.UUID;

public interface ProductApplicationService {
    CreateProductResponse createProduct(CreateProduct createProduct);
    GetProductResponse getProduct(UUID productID);
}
