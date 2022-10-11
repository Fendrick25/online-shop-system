package com.online.shop.system.shop.service.domain.create.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class ProductNotFoundResponse extends GetProductResponse{
    @NotNull
    private final String message;
}
