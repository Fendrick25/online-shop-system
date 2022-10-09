package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.event.OrderCancelledEvent;
import com.online.shop.system.shop.service.domain.event.OrderCreatedEvent;
import com.online.shop.system.shop.service.domain.event.OrderPaidEvent;

public interface ShopDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order);
    OrderPaidEvent payOrder(Order order);
    OrderCancelledEvent cancelOrder(Order order);
}
