package com.online.shop.system.shop.service.domain.service;


import com.online.shop.system.shop.service.domain.entity.CartItem;

public interface CartDomainService {
    CartItem addToCart(CartItem cartItem);
}
