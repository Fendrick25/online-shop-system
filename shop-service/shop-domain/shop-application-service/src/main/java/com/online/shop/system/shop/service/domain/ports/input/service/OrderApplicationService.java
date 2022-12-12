package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.PayOrder;
import com.online.shop.system.shop.service.domain.create.response.CreateOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.OrderCancelledResponse;
import com.online.shop.system.shop.service.domain.create.response.OrderPaidResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrder createOrder);
    GetOrderResponse getOrder(UUID orderID);
    OrderPaidResponse payOrder(@Valid PayOrder payOrder);
    OrderCancelledResponse cancelOrder(UUID orderID);

    void orderReceived(UUID orderID);
}
