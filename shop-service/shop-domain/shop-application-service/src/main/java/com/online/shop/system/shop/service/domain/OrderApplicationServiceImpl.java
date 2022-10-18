package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.PayOrder;
import com.online.shop.system.shop.service.domain.create.response.CreateOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.OrderCancelledResponse;
import com.online.shop.system.shop.service.domain.create.response.OrderPaidResponse;
import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.mapper.OrderApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.OrderApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.CartRepository;
import com.online.shop.system.shop.service.domain.ports.output.repository.OrderRepository;
import com.online.shop.system.shop.service.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrder createOrder) {
        Order order = orderDomainService.validateAndInitiateOrder(orderApplicationMapper.createOrderToOrder(createOrder));
        orderRepository.createOrder(order);
        createOrder.getItems().forEach(cartItem -> cartRepository.deleteCartItem(cartItem.getCartItemID()));
        return new CreateOrderResponse(order.getId().getValue());
    }

    @Override
    public GetOrderResponse getOrder(UUID orderID) {
        return orderApplicationMapper.orderToGetOrderResponse(orderRepository.getOrder(orderID).get());
    }

    @Override
    public OrderPaidResponse payOrder(PayOrder payOrder) {
        Order order = orderRepository.getOrder(payOrder.getOrderID()).get();
        Order orderPaid = Order.builder()
                .orderID(order.getId())
                .orderStatus(order.getOrderStatus())
                .tracking(order.getTracking())
                .build();
        orderDomainService.payOrder(orderPaid);
        orderRepository.payOrder(orderPaid, payOrder.getAmount());
        return new OrderPaidResponse(orderPaid.getId().getValue());
    }

    @Override
    public OrderCancelledResponse cancelOrder(UUID orderID) {
        Order order = orderRepository.getOrder(orderID).get();
        orderDomainService.cancelOrder(order);
        orderRepository.cancelOrder(order);
        return new OrderCancelledResponse(orderID);
    }

    @Override
    public void orderReceived(UUID orderID) {
        Order order = orderRepository.getOrder(orderID).get();
        orderDomainService.receiveOrder(order);
        orderRepository.orderReceived(order);
    }
}
