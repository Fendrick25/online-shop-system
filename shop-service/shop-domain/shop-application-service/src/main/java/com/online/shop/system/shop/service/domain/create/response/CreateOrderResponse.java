package com.online.shop.system.shop.service.domain.create.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final UUID orderID;
}
