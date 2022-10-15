package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.service.TrackingOrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrackingOrderServiceImpl implements TrackingOrderService {
    @Override
    public void deliverOrder(Order order) {
        order.getTracking().onDelivery();
    }

    @Override
    public void orderDelivered(Order order) {
        order.getTracking().delivered();
    }
}
