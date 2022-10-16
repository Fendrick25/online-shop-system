package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.UserEntity;
import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataAccessMapper {

    private final CartDataAccessMapper cartDataAccessMapper;

    public UserEntity userToUserEntity(User user){
        return UserEntity.builder()
                .id(user.getId().getValue())
                .username(user.getUsername())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .cart(cartDataAccessMapper.cartToCartEntity(user.getCart()))
                .build();
    }

    public User userEntityToUser(UserEntity userEntity){
        return User.builder()
                .userID(new UserID(userEntity.getId()))
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .phoneNumber(userEntity.getPhoneNumber())
                .email(userEntity.getEmail())
                .build();
    }
}
