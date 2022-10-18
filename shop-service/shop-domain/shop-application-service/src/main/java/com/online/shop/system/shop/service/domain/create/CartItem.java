package com.online.shop.system.shop.service.domain.create;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class CartItem {
    @NotNull
    private final UUID cartItemID;
    @NotNull
    private final UUID productID;
    private final String name;
    private final byte[] image;
    private final BigDecimal price;
    private final int quantity;
    private final BigDecimal subTotal;
}
