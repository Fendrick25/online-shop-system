package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.entity.Cart;
import com.online.shop.system.shop.service.domain.entity.CartItemE;

import java.util.UUID;

public interface CartRepository {
    void addToCart(CartItemE cartItem);
    Cart getCart(UUID cartID);
    void deleteCartItem(UUID cartItemID);

    void updateCartItem(UUID cartItemID, OrderItem orderItem);
}
