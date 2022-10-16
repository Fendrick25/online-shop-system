package com.online.shop.system.shop.service.domain.create.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AddToCartResponse {

    private final UUID cartItemID;
}
