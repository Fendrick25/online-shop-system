package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.OrderItemID;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderItemE extends BaseEntity<OrderItemID> {
    private OrderID orderID;
    private final Item item;

    @Builder
    public OrderItemE(OrderItemID orderItemID, OrderID orderID, Item item) {
        super.setId(orderItemID);
        this.orderID = orderID;
        this.item = item;
    }

    void initializeOrderItem(OrderID orderID, OrderItemID orderItemID) {
        this.orderID = orderID;
        super.setId(orderItemID);
    }

    boolean isPriceValid() {
        return item.getPrice().isGreaterThanZero() &&
                item.getPrice().equals(item.getProduct().getPrice()) &&
                item.getPrice().multiply(item.getQuantity()).equals(item.getSubTotal());
    }
}
