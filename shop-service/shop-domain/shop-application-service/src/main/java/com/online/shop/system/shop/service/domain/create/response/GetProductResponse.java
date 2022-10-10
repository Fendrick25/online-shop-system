package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;


@Getter
@Builder
@RequiredArgsConstructor
public class GetProductResponse {
    @NotNull
    private final Product product;
}
