package com.online.shop.system.shop.service.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class PayOrder {

    private final UUID orderID;
    private final BigDecimal amount;
}
