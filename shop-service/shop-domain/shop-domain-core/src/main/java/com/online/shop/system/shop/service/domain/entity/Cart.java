package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.AggregateRoot;
import com.online.shop.system.shop.service.domain.entity.base.CartID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class Cart extends AggregateRoot<CartID> {
    private final UserID userID;
    private List<CartItemE> items;
    private Money price;

    public Cart(UserID userID) {
        this.userID = userID;
    }

    @Builder
    public Cart(CartID cartID, UserID userID, List<CartItemE> items, Money price) {
        super.setId(cartID);
        this.userID = userID;
        this.items = items;
        this.price = price;
    }

    public void initCart(){
        setId(new CartID(UUID.randomUUID()));
        price = new Money(Money.ZERO.getAmount());
        items = new ArrayList<>();
    }

}
