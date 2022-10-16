package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.CartEntity;
import com.online.shop.system.shop.service.dataaccess.entity.CartItemEntity;
import com.online.shop.system.shop.service.domain.entity.Cart;
import com.online.shop.system.shop.service.domain.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartDataAccessMapper {

    private final ProductDataAccessMapper productDataAccessMapper;

    public CartItemEntity cartItemToCartItemEntity(CartItem cartItem){
        return CartItemEntity.builder()
                .id(cartItem.getId().getValue())
                .quantity(cartItem.getItem().getQuantity())
                .price(cartItem.getItem().getPrice().getAmount())
                .subTotal(cartItem.getItem().getSubTotal().getAmount())
                .build();
    }

    public CartEntity cartToCartEntity(Cart cart){
        return CartEntity.builder()
                .id(cart.getId().getValue())
                .build();
    }

}
