package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final OrderID orderID;
}
