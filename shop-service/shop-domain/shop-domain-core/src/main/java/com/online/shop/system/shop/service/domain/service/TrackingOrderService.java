package com.online.shop.system.shop.service.domain.service;

import com.online.shop.system.shop.service.domain.entity.Order;

public interface TrackingOrderService {
    void deliverOrder(Order order);
    void orderDelivered(Order order);
}
