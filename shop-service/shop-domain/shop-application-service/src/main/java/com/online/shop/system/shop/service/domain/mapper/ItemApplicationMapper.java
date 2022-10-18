package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CartItem;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.entity.Item;
import com.online.shop.system.shop.service.domain.entity.Money;
import com.online.shop.system.shop.service.domain.entity.OrderItemE;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemApplicationMapper {

    public Item orderItemToItem(OrderItem orderItem){
        return Item.builder()
                .product(new Product(new ProductID(orderItem.getProductID())))
                .price(new Money(orderItem.getPrice()))
                .quantity(orderItem.getQuantity())
                .subTotal(new Money(orderItem.getSubTotal()))
                .build();
    }

}
