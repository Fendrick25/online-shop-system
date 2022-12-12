package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface UserApplicationService {
    CreateUserResponse createUser(@Valid CreateUser createUser);
    void addAddress(UUID userID, @Valid OrderAddress orderAddress);
    void deleteAddress(UUID addressID);
    void updateAddress(UUID addressID, @Valid OrderAddress orderAddress);
}
