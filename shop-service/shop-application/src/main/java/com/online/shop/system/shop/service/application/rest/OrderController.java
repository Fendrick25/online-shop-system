package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.CreateOrder;
import com.online.shop.system.shop.service.domain.create.response.CreateOrderResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.create.response.GetOrderResponse;
import com.online.shop.system.shop.service.domain.ports.input.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    @PostMapping
    public ResponseEntity<Data<CreateOrderResponse>> createOrder(@RequestBody CreateOrder createOrder){
        return new ResponseEntity<>(new Data<>(orderApplicationService.createOrder(createOrder), "Order created"), HttpStatus.CREATED);
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<Data<GetOrderResponse>> getOrder(@PathVariable("orderID") UUID orderID){
        return new ResponseEntity<>(new Data<>(orderApplicationService.getOrder(orderID), "Order found"), HttpStatus.FOUND);
    }


}
