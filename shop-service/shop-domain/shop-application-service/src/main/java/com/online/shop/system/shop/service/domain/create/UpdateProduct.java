package com.online.shop.system.shop.service.domain.create;

import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateProduct {
    private final UUID id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final ProductStatus status;
    private final int quantity;
}
