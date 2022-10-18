package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;

import java.util.UUID;

public interface UserApplicationService {
    CreateUserResponse createUser(CreateUser createUser);
    void addAddress(UUID userID, OrderAddress orderAddress);
    void deleteAddress(UUID addressID);
    void updateAddress(UUID addressID, OrderAddress orderAddress);
}
