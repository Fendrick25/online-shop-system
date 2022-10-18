package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.Order;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    void createOrder(Order order);
    Optional<Order> getOrder(UUID orderID);
    void payOrder(Order order, BigDecimal amount);
    void cancelOrder(Order order);
    void orderReceived(Order order);
}
