package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.CartItem;
import com.online.shop.system.shop.service.domain.service.CartDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartDomainServiceImpl implements CartDomainService {

    @Override
    public CartItem addToCart(CartItem cartItem) {
        cartItem.initCartItem();
        return cartItem;
    }
}
