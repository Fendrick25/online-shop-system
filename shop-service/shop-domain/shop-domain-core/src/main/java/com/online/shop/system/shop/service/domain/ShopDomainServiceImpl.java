package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.event.OrderCancelledEvent;
import com.online.shop.system.shop.service.domain.event.OrderCreatedEvent;
import com.online.shop.system.shop.service.domain.event.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.online.shop.system.shop.service.domain.DomainConstants.UTC;

@Slf4j
public class ShopDomainServiceImpl implements ShopDomainService{
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order) {
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderCancelledEvent cancelOrder(Order order) {
        log.info("Order is cancelled for order id: {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }
}
