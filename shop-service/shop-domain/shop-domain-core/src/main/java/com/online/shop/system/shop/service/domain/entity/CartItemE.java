package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.CartID;
import com.online.shop.system.shop.service.domain.entity.base.CartItemID;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CartItemE extends BaseEntity<CartItemID> {
    private final CartID cartID;
    private final Item item;

    @Builder
    public CartItemE(CartItemID cartItemID, CartID cartID, Item item) {
        super.setId(cartItemID);
        this.cartID = cartID;
        this.item = item;
    }

    public void initCartItem(){
        super.setId(new CartItemID(UUID.randomUUID()));
    }
}
