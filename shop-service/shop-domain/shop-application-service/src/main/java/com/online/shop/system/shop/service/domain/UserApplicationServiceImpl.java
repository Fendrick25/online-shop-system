package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;
import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.mapper.UserApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.UserApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.UserRepository;
import com.online.shop.system.shop.service.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserApplicationMapper userMapper;
    private final UserDomainService userDomainService;
    private final UserRepository userRepository;

    @Override
    public CreateUserResponse createUser(CreateUser createUser) {
        User user = userDomainService.validateUser(userMapper.createUserToUser(createUser));
        userRepository.createUser(user);
        return new CreateUserResponse(user.getId().getValue());
    }
}

