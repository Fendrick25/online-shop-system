package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.ports.input.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartApplicationService cartApplicationService;

    @PatchMapping
    public ResponseEntity<Data<AddToCartResponse>> addToCart(@RequestBody AddToCart addToCart){
        return new ResponseEntity<>(new Data<>(cartApplicationService.addToCart(addToCart), "Added to cart"), HttpStatus.CREATED);
    }


}
