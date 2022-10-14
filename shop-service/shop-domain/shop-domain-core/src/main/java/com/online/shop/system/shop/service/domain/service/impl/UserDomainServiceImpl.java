package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.service.UserDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDomainServiceImpl implements UserDomainService {
    @Override
    public User validateUser(User user) {
        user.initializeUser();
        log.info("User with id: {} is initialized", user.getId().getValue());
        return user;
    }
}
