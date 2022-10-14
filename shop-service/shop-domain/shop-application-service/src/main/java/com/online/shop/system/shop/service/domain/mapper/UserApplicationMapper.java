package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserApplicationMapper {

    public User createUserToUser(CreateUser createUser){
        return User.builder()
                .username(createUser.getUsername())
                .password(createUser.getPassword())
                .email(createUser.getEmail())
                .phoneNumber(createUser.getPhoneNumber())
                .build();
    }
}
