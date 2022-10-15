package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.ports.input.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public ResponseEntity<Data<CreateUserResponse>> createUser(@RequestBody CreateUser createUser){
        return new ResponseEntity<>(new Data<>(userApplicationService.createUser(createUser), "User created"), HttpStatus.CREATED);
    }
}
