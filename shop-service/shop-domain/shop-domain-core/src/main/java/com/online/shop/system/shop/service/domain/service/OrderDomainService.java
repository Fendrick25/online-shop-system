package com.online.shop.system.shop.service.domain.service;

import com.online.shop.system.shop.service.domain.entity.Order;

public interface OrderDomainService {
    Order validateAndInitiateOrder(Order order);
    Order payOrder(Order order);
    Order cancelOrder(Order order);
    Order receiveOrder(Order order);
}
