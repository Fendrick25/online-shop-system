package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.response.CreateOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;

import java.util.UUID;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(CreateOrder createOrder);
    GetOrderResponse getOrder(UUID orderID);
}
