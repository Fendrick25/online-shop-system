package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;

public interface UserApplicationService {
    CreateUserResponse createUser(CreateUser createUser);
}
