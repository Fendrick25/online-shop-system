package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;

public interface CartApplicationService {
    AddToCartResponse addToCart(AddToCart addToCart);
}
