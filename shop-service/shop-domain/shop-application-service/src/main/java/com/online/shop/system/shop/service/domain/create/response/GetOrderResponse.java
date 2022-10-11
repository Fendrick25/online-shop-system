package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class GetOrderResponse {
    @NotNull
    private Order order;
}
