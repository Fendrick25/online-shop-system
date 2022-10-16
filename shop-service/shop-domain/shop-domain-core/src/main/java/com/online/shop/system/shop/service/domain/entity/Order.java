package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.*;
import com.online.shop.system.shop.service.domain.exception.ShopDomainException;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import com.online.shop.system.shop.service.domain.valueobject.OrderStatus;
import com.online.shop.system.shop.service.domain.valueobject.TrackingStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.online.shop.system.shop.service.domain.DomainConstants.UTC;

@Getter
public class Order extends AggregateRoot<OrderID> {
    private final UserID userID;
    private final Address deliveryAddress;
    private final Money price;
    private List<OrderItemE> items;
    private OrderStatus orderStatus;
    private Tracking tracking;

    private ZonedDateTime createdAt;

    public void initializeOrder(){
        setId(new OrderID(UUID.randomUUID()));
        orderStatus = OrderStatus.PENDING;
        tracking = new Tracking();
        tracking.initTracking();
        this.createdAt = ZonedDateTime.now(ZoneId.of(UTC));
        initializeOrderItems();
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay(){
        if (orderStatus != OrderStatus.PENDING) {
            throw new ShopDomainException("Order is not in correct state for pay operation!");
        }
        tracking.setTrackingStatus(TrackingStatus.ONPROCESS);
        orderStatus = OrderStatus.PAID;
    }

    public void cancel() {
        if (!(orderStatus == OrderStatus.PENDING)) {
            throw new ShopDomainException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
        tracking.setTrackingStatus(TrackingStatus.CANCELLED);
    }

    public void received(){
        if(!(tracking.getTrackingStatus() == TrackingStatus.DELIVERED)){
            throw new ShopDomainException("Order is not in correct state for received operation");
        }
        orderStatus = OrderStatus.FINISHED;
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
            return orderItem.getItem().getSubTotal();
        }).reduce(Money.ZERO, Money::add);

        if (!price.equals(orderItemsTotal)) {
            throw new ShopDomainException("Total price: " + price.getAmount()
                    + " is not equal to Order items total: " + orderItemsTotal.getAmount() + "!");
        }
    }

    private void validateItemPrice(OrderItemE orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new ShopDomainException("Order item price: " + orderItem.getItem().getPrice().getAmount() +
                    " is not valid for product " + orderItem.getItem().getProduct().getId().getValue());
        }
    }

    private void initializeOrderItems() {
        for (OrderItemE orderItem: items) {
            orderItem.initializeOrderItem(super.getId(), new OrderItemID(UUID.randomUUID()));
        }
    }

    @Builder
    public Order(OrderID orderID, UserID userID, Address deliveryAddress, Money price, List<OrderItemE> items, OrderStatus orderStatus, Tracking tracking, ZonedDateTime createdAt) {
        super.setId(orderID);
        this.userID = userID;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.items = items;
        this.orderStatus = orderStatus;
        this.tracking = tracking;
        this.createdAt = createdAt;
    }
}
