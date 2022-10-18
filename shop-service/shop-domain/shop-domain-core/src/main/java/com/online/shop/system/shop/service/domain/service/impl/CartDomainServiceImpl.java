package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.CartItemE;
import com.online.shop.system.shop.service.domain.service.CartDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartDomainServiceImpl implements CartDomainService {

    @Override
    public CartItemE addToCart(CartItemE cartItem) {
        cartItem.initCartItem();
        return cartItem;
    }
}
