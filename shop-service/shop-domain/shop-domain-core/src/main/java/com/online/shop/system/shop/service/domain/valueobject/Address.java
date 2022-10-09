package com.online.shop.system.shop.service.domain.valueobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Address {
    private final UUID id;
    private final String street;
    private final String postalCode;
    private final String city;
}
