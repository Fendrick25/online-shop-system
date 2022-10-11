package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.entity.OrderItemE;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderApplicationMapper {
    public Order createOrderToOrder(CreateOrder createOrder){
        return Order.builder()
                .userID(new UserID(createOrder.getUserID()))
                .price(new Money(createOrder.getPrice()))
                .items(orderItemsToOrderItemsE(createOrder.getItems()))
                .deliveryAddress(orderAddressToAddress(createOrder.getAddress()))
                .build();
    }

    public List<OrderItemE> orderItemsToOrderItemsE(List<OrderItem> orderItems){
        return orderItems.stream()
                .map(orderItem ->
                        OrderItemE.builder()
                                .product(new Product(new ProductID(orderItem.getProductID())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private Address orderAddressToAddress(OrderAddress orderAddress){
        return Address.builder()
                .street(orderAddress.getStreet())
                .city(orderAddress.getCity())
                .postalCode(orderAddress.getPostalCode())
                .build();
    }

}
