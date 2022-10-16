package com.online.shop.system.shop.service.domain.create;

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
public class CreateOrder {

    @NotNull
    private final UUID cartID;
    @NotNull
    private final UUID userID;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final OrderAddress address;
    @NotNull
    private final List<OrderItem> items;
}
