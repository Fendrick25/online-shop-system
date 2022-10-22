package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.CartItem;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.response.GetCartResponse;
import com.online.shop.system.shop.service.domain.entity.*;
import com.online.shop.system.shop.service.domain.entity.base.CartID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartApplicationMapper {

    private final ItemApplicationMapper itemApplicationMapper;

    public CartItemE addToCartToCartItem(AddToCart addToCart){
        return CartItemE.builder()
                .cartID(new CartID(addToCart.getCartID()))
                .item(itemApplicationMapper.orderItemToItem(addToCart.getOrderItem()))
                .build();

    }

    public GetCartResponse cartToGetCartResponse(Cart cart){
        return GetCartResponse.builder()
                .cartID(cart.getId().getValue())
                .userID(cart.getUserID().getValue())
                .cartItems(cartItemEStoCartItems(cart.getItems()))
                .build();
    }

    private List<CartItem> cartItemEStoCartItems(List<CartItemE> cartItemES){
        return cartItemES.stream()
                .map(cartItemE -> CartItem.builder()
                        .cartItemID(cartItemE.getId().getValue())
                        .productID(cartItemE.getItem().getProduct().getId().getValue())
                        .name(cartItemE.getItem().getProduct().getName())
                        .image(cartItemE.getItem().getProduct().getImages().get(0))
                        .price(cartItemE.getItem().getPrice().getAmount())
                        .quantity(cartItemE.getItem().getQuantity())
                        .subTotal(cartItemE.getItem().getSubTotal().getAmount())
                        .build()).collect(Collectors.toList());
    }



}
