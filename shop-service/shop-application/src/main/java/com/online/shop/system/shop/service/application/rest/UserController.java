package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.CreateUser;
import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.create.response.CreateUserResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.ports.input.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public ResponseEntity<Data<CreateUserResponse>> createUser(@RequestBody CreateUser createUser){
        return new ResponseEntity<>(new Data<>(userApplicationService.createUser(createUser), "User created"), HttpStatus.CREATED);
    }

    @PostMapping("/{userID}/address")
    public ResponseEntity<?> addAddress(@PathVariable("userID") UUID userID,  @RequestBody OrderAddress orderAddress){
        userApplicationService.addAddress(userID, orderAddress);
        return new ResponseEntity<>(new Data<>("Address added for user id: " + userID, "Address added"), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/address/{addressID}")
    public ResponseEntity<?> updateAddress(@PathVariable("addressID") UUID addressID,  @RequestBody OrderAddress orderAddress){
        userApplicationService.updateAddress(addressID, orderAddress);
        return new ResponseEntity<>(new Data<>("Address updated for address id: " + addressID, "Address updated"), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/address/{addressID}")
    public ResponseEntity<?> deleteAddress(@PathVariable("addressID") UUID addressID){
        userApplicationService.deleteAddress(addressID);
        return new ResponseEntity<>(new Data<>("Address deleted for address id: " + addressID, "Address deleted"), HttpStatus.ACCEPTED);
    }
}
