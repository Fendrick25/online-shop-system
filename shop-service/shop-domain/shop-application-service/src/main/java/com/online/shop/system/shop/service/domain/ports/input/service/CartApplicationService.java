package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.create.response.GetCartResponse;

import java.util.UUID;

public interface CartApplicationService {
    AddToCartResponse addToCart(AddToCart addToCart);
    GetCartResponse getCart(UUID cartID);
    String deleteCartItem(UUID cartItemID);
    String updateCartItem(UUID cartItemID, OrderItem orderItem);
}
