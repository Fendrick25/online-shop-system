package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.OrderItemID;
import lombok.Builder;
import lombok.Getter;


@Getter
public class OrderItemE extends BaseEntity<OrderItemID> {
    private OrderID orderID;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    @Builder
    public OrderItemE(OrderItemID orderItemID, Product product, int quantity, Money price, Money subTotal) {
        super.setId(orderItemID);
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subTotal);
    }
}
