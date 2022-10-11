package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.valueobject.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class User {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private Address userAddress;
}
