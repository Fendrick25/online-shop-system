package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;
import com.online.shop.system.shop.service.domain.entity.*;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderApplicationMapper {

    private final ItemApplicationMapper itemApplicationMapper;
    public Order createOrderToOrder(CreateOrder createOrder){
        return Order.builder()
                .userID(new UserID(createOrder.getUserID()))
                .price(new Money(createOrder.getPrice()))
                .items(orderItemsToOrderItemEs(createOrder.getItems()))
                .deliveryAddress(orderAddressToAddress(createOrder.getAddress()))
                .build();
    }

    public List<OrderItemE> orderItemsToOrderItemEs(List<OrderItem> orderItems){
        return orderItems.stream()
                .map(orderItem ->
                        OrderItemE.builder()
                                .item(itemApplicationMapper.orderItemToItem(orderItem))
                                .build()).collect(Collectors.toList());
    }

    public GetOrderResponse orderToGetOrderResponse(Order order){
        return GetOrderResponse.builder()
                .orderID(order.getId().getValue())
                .userID(order.getUserID().getValue())
                .price(order.getPrice().getAmount())
                .deliveryAddress(order.getDeliveryAddress())
                .items(orderItemESToOrderItems(order.getItems()))
                .orderStatus(order.getOrderStatus())
                .tracking(order.getTracking())
                .build();
    }

    private Address orderAddressToAddress(OrderAddress orderAddress){
        return Address.builder()
                .street(orderAddress.getStreet())
                .city(orderAddress.getCity())
                .postalCode(orderAddress.getPostalCode())
                .build();
    }

    public List<OrderItem> orderItemESToOrderItems(List<OrderItemE> orderItemES){
        return orderItemES.stream()
                .map(orderItemE -> OrderItem.builder()
                        .productID(orderItemE.getItem().getProduct().getId().getValue())
                        .quantity(orderItemE.getItem().getQuantity())
                        .price(orderItemE.getItem().getPrice().getAmount())
                        .subTotal(orderItemE.getItem().getSubTotal().getAmount())
                        .build()).collect(Collectors.toList());
    }


}
