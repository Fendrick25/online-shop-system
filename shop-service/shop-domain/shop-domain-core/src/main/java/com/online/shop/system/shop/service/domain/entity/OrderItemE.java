package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.OrderItemID;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;


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

    void initializeOrderItem(OrderID orderID, OrderItemID orderItemID) {
        this.orderID = orderID;
        super.setId(orderItemID);
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.multiply(quantity).equals(subTotal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderItemE that = (OrderItemE) o;
        return orderID.equals(that.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderID);
    }
}
