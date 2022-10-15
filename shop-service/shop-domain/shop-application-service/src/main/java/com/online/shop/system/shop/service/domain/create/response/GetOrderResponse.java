package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.entity.OrderItemE;
import com.online.shop.system.shop.service.domain.entity.Tracking;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import com.online.shop.system.shop.service.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetOrderResponse {
    @NotNull
    private final UUID orderID;

    @NotNull
    private final UUID userID;

    @NotNull
    private final BigDecimal price;

    @NotNull
    private final Address deliveryAddress;

    @NotNull
    private List<OrderItem> items;

    @NotNull
    private OrderStatus orderStatus;


    private Tracking tracking;
}
