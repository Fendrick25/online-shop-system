package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.OrderEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.entity.UserEntity;
import com.online.shop.system.shop.service.dataaccess.exception.MoneyNotEqualException;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.OrderDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.OrderJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.ProductJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.UserJpaRepository;
import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.ports.output.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    private final UserJpaRepository userJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Override
    @Transactional
    public void createOrder(Order order) {
        OrderEntity orderEntity = orderDataAccessMapper.orderToOrderEntity(order);
        UserEntity userEntity = userJpaRepository.findById(order.getUserID().getValue()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        orderEntity.getOrderItems().forEach(orderItemEntity -> {
            ProductEntity productEntity = productJpaRepository.findById(orderItemEntity.getProduct().getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            orderItemEntity.setOrder(orderEntity);
            orderItemEntity.setProduct(productEntity);
        });
        orderEntity.setUser(userEntity);
        orderJpaRepository.save(orderEntity);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> getOrder(UUID orderID) {
        return Optional.ofNullable(orderJpaRepository.findById(orderID).map(orderDataAccessMapper::orderEntityToOrder).orElseThrow(() -> new ResourceNotFoundException("Order not found")));
    }

    @Override
    @Transactional
    public void payOrder(Order order, BigDecimal amount) {
        OrderEntity orderEntity = orderJpaRepository.findById(order.getId().getValue()).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        orderEntity.setOrderStatus(order.getOrderStatus());
        orderEntity.setTracking(orderDataAccessMapper.trackingToTrackingEntity(order.getTracking()));
        if(!(orderEntity.getPrice().equals(amount)))
            throw new MoneyNotEqualException("Money not equals to price");


        orderJpaRepository.save(orderEntity);
    }
}
