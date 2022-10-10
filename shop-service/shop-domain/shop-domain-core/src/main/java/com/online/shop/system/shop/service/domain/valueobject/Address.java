package com.online.shop.system.shop.service.domain.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class Address {
    private final String street;
    private final String postalCode;
    private final String city;
}
