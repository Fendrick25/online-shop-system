package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.service.OrderDomainService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public Order validateAndInitiateOrder(Order order) {
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return order;
    }

    @Override
    public Order payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return order;
    }

    @Override
    public Order cancelOrder(Order order) {
        order.cancel();
        log.info("Order is cancelled for order id: {}", order.getId().getValue());
        return order;
    }

    @Override
    public Order receiveOrder(Order order) {
        order.received();
        log.info("Order received for order id: {}", order.getId().getValue());
        return order;
    }
}
