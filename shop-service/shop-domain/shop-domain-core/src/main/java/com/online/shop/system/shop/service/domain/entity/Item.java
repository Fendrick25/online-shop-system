package com.online.shop.system.shop.service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class Item{
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

}
