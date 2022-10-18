package com.online.shop.system.shop.service.domain.service;


import com.online.shop.system.shop.service.domain.entity.CartItemE;

public interface CartDomainService {
    CartItemE addToCart(CartItemE cartItem);
}
