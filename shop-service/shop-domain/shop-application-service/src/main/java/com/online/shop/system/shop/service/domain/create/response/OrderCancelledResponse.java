package com.online.shop.system.shop.service.domain.create.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class OrderCancelledResponse {
    private final UUID orderID;
}
