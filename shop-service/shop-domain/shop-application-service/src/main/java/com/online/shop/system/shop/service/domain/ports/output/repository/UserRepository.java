package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.valueobject.Address;

import java.util.UUID;

public interface UserRepository {
    void createUser(User user);
    void addAddress(Address address);
    void deleteAddress(UUID addressID);
    void updateAddress(UUID addressID, Address address);
}
