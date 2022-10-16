package com.online.shop.system.shop.service.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AddToCart {

    @NotNull
    private final UUID cartID;
    @NotNull
    private final OrderItem orderItem;
}
