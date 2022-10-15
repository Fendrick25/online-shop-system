package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.UserEntity;
import com.online.shop.system.shop.service.dataaccess.mapper.UserDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.UserJpaRepository;
import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    @Override
    @Transactional
    public void createUser(User user) {
        userJpaRepository.save(userDataAccessMapper.userToUserEntity(user));
    }
}
