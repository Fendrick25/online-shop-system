package com.online.shop.system.shop.service.domain.create.response;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Data<T> {
    private final T data;
    private final String message;

    public Data(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
