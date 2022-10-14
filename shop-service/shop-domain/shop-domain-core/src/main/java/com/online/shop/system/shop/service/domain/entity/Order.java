package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.*;
import com.online.shop.system.shop.service.domain.exception.ShopDomainException;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import com.online.shop.system.shop.service.domain.valueobject.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order extends AggregateRoot<OrderID> {
    private final UserID userID;
    private final Address deliveryAddress;
    private final Money price;
    private List<OrderItemE> items;
    private OrderStatus orderStatus;

    private Tracking tracking;

    public void initializeOrder(){
        setId(new OrderID(UUID.randomUUID()));
        orderStatus = OrderStatus.PENDING;
        initializeOrderItems();
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay(){
        if (orderStatus != OrderStatus.PAID) {
            throw new ShopDomainException("Order is not in correct state for pay operation!");
        }
        tracking.setId(new TrackingID(UUID.randomUUID()));
    }

    public void cancel() {
        if (!(orderStatus == OrderStatus.PENDING)) {
            throw new ShopDomainException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
    }

    private void validateInitialOrder() {
        if (orderStatus != null || getId() != null) {
            throw new ShopDomainException("Order is not in correct state for initialization!");
        }
    }
    private void validateTotalPrice() {
        if (price == null || !price.isGreaterThanZero()) {
            throw new ShopDomainException("Total price must be greater than zero!");
        }
    }

    private void validateItemsPrice() {
        Money orderItemsTotal = items.stream().map(orderItem -> {
            validateItemPrice(orderItem);
            return orderItem.getSubTotal();
        }).reduce(Money.ZERO, Money::add);

        if (!price.equals(orderItemsTotal)) {
            throw new ShopDomainException("Total price: " + price.getAmount()
                    + " is not equal to Order items total: " + orderItemsTotal.getAmount() + "!");
        }
    }

    private void validateItemPrice(OrderItemE orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new ShopDomainException("Order item price: " + orderItem.getPrice().getAmount() +
                    " is not valid for product " + orderItem.getProduct().getId().getValue());
        }
    }

    private void initializeOrderItems() {
        long itemID = 1;
        for (OrderItemE orderItem: items) {
            orderItem.initializeOrderItem(super.getId(), new OrderItemID(itemID++));
        }
    }

    @Builder
    public Order(UserID userID, Address deliveryAddress, Money price, List<OrderItemE> items) {
        this.userID = userID;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.items = items;
    }
}
