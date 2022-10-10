package com.online.shop.system.shop.service.domain.create.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
public abstract class Data<T> {
    private final T value;
}
