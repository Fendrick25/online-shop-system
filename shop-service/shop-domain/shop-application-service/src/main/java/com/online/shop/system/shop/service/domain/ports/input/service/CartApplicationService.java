package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.create.response.GetCartResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface CartApplicationService {
    AddToCartResponse addToCart(@Valid AddToCart addToCart);
    GetCartResponse getCart(@Valid UUID cartID);
    String deleteCartItem(@Valid UUID cartItemID);
    String updateCartItem(UUID cartItemID, OrderItem orderItem);
}
