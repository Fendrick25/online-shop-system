package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.CartItem;

public interface CartRepository {
    void addToCart(CartItem cartItem);
}
