package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.User;

public interface UserRepository {
    User createUser(User user);
}
