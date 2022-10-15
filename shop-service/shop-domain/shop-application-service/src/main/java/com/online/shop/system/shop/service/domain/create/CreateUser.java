package com.online.shop.system.shop.service.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateUser {
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @Email
    private final String email;
    @NotNull
    private final String phoneNumber;
}
