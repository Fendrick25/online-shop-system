package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.create.response.GetCartResponse;
import com.online.shop.system.shop.service.domain.ports.input.service.CartApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/carts")
public class CartController {

    private final CartApplicationService cartApplicationService;

    @PatchMapping
    public ResponseEntity<Data<AddToCartResponse>> addToCart(@RequestBody AddToCart addToCart){
        return new ResponseEntity<>(new Data<>(cartApplicationService.addToCart(addToCart), "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/{cartID}")
    public ResponseEntity<Data<GetCartResponse>> getCart(@PathVariable("cartID") UUID cartID){
        return new ResponseEntity<>(new Data<>(cartApplicationService.getCart(cartID), "Cart found"), HttpStatus.OK);
    }

    @DeleteMapping("/item/{cartItemID}")
    public ResponseEntity<Data<String>> deleteCartItem(@PathVariable("cartItemID") UUID cartItemID){
        return new ResponseEntity<>(new Data<>(cartApplicationService.deleteCartItem(cartItemID), "Cart item deleted"), HttpStatus.OK);
    }

    @PatchMapping("/item/{cartItemID}")
    public ResponseEntity<Data<String>> updateCartItem(@PathVariable("cartItemID") UUID cartItemID, @RequestBody OrderItem orderItem){
        return new ResponseEntity<>(new Data<>(cartApplicationService.updateCartItem(cartItemID, orderItem), "Cart item updated"), HttpStatus.OK);
    }


}
