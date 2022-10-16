package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.entity.*;
import com.online.shop.system.shop.service.domain.entity.base.CartID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartApplicationMapper {

    private final ItemApplicationMapper itemApplicationMapper;

    public CartItem addToCartToCartItem(AddToCart addToCart){
        return CartItem.builder()
                .cartID(new CartID(addToCart.getCartID()))
                .item(itemApplicationMapper.orderItemToItem(addToCart.getOrderItem()))
                .build();

    }




}
