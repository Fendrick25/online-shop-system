package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.OrderEntity;
import com.online.shop.system.shop.service.dataaccess.entity.OrderItemEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.entity.TrackingEntity;
import com.online.shop.system.shop.service.domain.entity.*;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.OrderItemID;
import com.online.shop.system.shop.service.domain.entity.base.TrackingID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderDataAccessMapper {

    private final ProductDataAccessMapper productDataAccessMapper;
    private final TrackingDataAccessMapper trackingDataAccessMapper;

    public OrderEntity orderToOrderEntity(Order order){
        return OrderEntity.builder()
                .id(order.getId().getValue())
                .deliveryAddress(order.getDeliveryAddress())
                .price(order.getPrice().getAmount())
                .orderItems(orderItemEToOrderItemEntity(order.getItems()))
                .orderStatus(order.getOrderStatus())
                .tracking(trackingToTrackingEntity(order.getTracking()))
                .createdAt(order.getCreatedAt())
                .build();
    }

    public TrackingEntity trackingToTrackingEntity(Tracking tracking){
        return TrackingEntity.builder()
                .id(tracking.getId().getValue())
                .trackingStatus(tracking.getTrackingStatus())
                .build();
    }

    public Order orderEntityToOrder(OrderEntity orderEntity){
        return Order.builder()
                .orderID(new OrderID(orderEntity.getId()))
                .userID(new UserID(orderEntity.getUser().getId()))
                .deliveryAddress(orderEntity.getDeliveryAddress())
                .price(new Money(orderEntity.getPrice()))
                .items(orderItemEntityToOrderItemES(orderEntity.getOrderItems()))
                .orderStatus(orderEntity.getOrderStatus())
                .tracking(trackingDataAccessMapper.trackingEntityToTracking(orderEntity.getTracking()))
                .createdAt(orderEntity.getCreatedAt())
                .build();
    }

    private List<OrderItemEntity> orderItemEToOrderItemEntity(List<OrderItemE> orderItemES){
        return orderItemES.stream()
                .map(orderItemE ->
                        OrderItemEntity.builder()
                                .id(orderItemE.getId().getValue())
                                .product(mapProductIDTOProductEntity(orderItemE.getItem().getProduct()))
                                .quantity(orderItemE.getItem().getQuantity())
                                .price(orderItemE.getItem().getPrice().getAmount())
                                .subTotal(orderItemE.getItem().getSubTotal().getAmount())
                                .build()).collect(Collectors.toList());
    }

    private ProductEntity mapProductIDTOProductEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId().getValue())
                .build();
    }
    private List<OrderItemE> orderItemEntityToOrderItemES(List<OrderItemEntity> orderItemEntities){
        return orderItemEntities.stream()
                .map(orderItemEntity ->
                        OrderItemE.builder()
                                .orderItemID(new OrderItemID(orderItemEntity.getId()))
                                .orderID(new OrderID(orderItemEntity.getOrder().getId()))
                                .item(Item.builder()
                                        .product(productDataAccessMapper.productEntityToProduct(orderItemEntity.getProduct()))
                                        .quantity(orderItemEntity.getQuantity())
                                        .price(new Money(orderItemEntity.getPrice()))
                                        .subTotal(new Money(orderItemEntity.getSubTotal()))
                                        .build())
                                .build()).collect(Collectors.toList());
    }



}
