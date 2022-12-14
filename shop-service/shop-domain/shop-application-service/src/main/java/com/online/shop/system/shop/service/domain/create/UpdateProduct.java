package com.online.shop.system.shop.service.domain.create;

import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateProduct {
    @NotNull
    private final UUID id;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final ProductStatus status;
    @NotNull
    private final int quantity;
}
