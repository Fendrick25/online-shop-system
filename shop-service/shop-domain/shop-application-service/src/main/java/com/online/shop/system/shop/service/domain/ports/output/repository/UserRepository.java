package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.User;

public interface UserRepository {
    void createUser(User user);
}
