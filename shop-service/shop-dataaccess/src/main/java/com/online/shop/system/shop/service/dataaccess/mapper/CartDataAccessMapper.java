package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.CartEntity;
import com.online.shop.system.shop.service.dataaccess.entity.CartItemEntity;
import com.online.shop.system.shop.service.domain.entity.*;
import com.online.shop.system.shop.service.domain.entity.base.CartID;
import com.online.shop.system.shop.service.domain.entity.base.CartItemID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartDataAccessMapper {

    private final ProductDataAccessMapper productDataAccessMapper;

    public CartItemEntity cartItemToCartItemEntity(CartItemE cartItem){
        return CartItemEntity.builder()
                .id(cartItem.getId().getValue())
                .quantity(cartItem.getItem().getQuantity())
                .subTotal(cartItem.getItem().getSubTotal().getAmount())
                .build();
    }

    public CartEntity cartToCartEntity(Cart cart){
        return CartEntity.builder()
                .id(cart.getId().getValue())
                .build();
    }

    public Cart cartEntityToCart(CartEntity cartEntity){
        return Cart.builder()
                .cartID(new CartID(cartEntity.getId()))
                .userID(new UserID(cartEntity.getUserEntity().getId()))
                .price(new Money(cartEntity.getPrice()))
                .items(cartItemEntitiesToCartItems(cartEntity.getItems()))
                .build();
    }

    private List<CartItemE> cartItemEntitiesToCartItems(List<CartItemEntity> cartItemEntities){
        return cartItemEntities.stream()
                .map(cartItemEntity -> CartItemE.builder()
                        .cartID(new CartID(cartItemEntity.getCart().getId()))
                        .cartItemID(new CartItemID(cartItemEntity.getId()))
                        .item(Item.builder()
                                .product(productDataAccessMapper.productEntityToProduct(cartItemEntity.getProduct()))
                                .price(new Money(cartItemEntity.getProduct().getPrice()))
                                .quantity(cartItemEntity.getQuantity())
                                .subTotal(new Money(cartItemEntity.getSubTotal()))
                                .build())
                        .build()).collect(Collectors.toList());
    }

}
