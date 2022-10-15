package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.response.CreateOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;
import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.mapper.OrderApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.OrderApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.OrderRepository;
import com.online.shop.system.shop.service.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderApplicationMapper orderApplicationMapper;
    private final OrderRepository orderRepository;
    private final OrderDomainService orderDomainService;

    @Override
    public CreateOrderResponse createOrder(CreateOrder createOrder) {
        Order order = orderDomainService.validateAndInitiateOrder(orderApplicationMapper.createOrderToOrder(createOrder));
        orderRepository.createOrder(order);
        return new CreateOrderResponse(order.getId().getValue());
    }

    @Override
    public GetOrderResponse getOrder(UUID orderID) {
        return orderApplicationMapper.orderToGetOrderResponse(orderRepository.getOrder(orderID).get());
    }
}
