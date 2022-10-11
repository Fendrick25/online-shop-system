package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.response.CreateProductResponse;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;
import com.online.shop.system.shop.service.domain.create.response.ProductNotFoundResponse;
import com.online.shop.system.shop.service.domain.ports.input.service.ProductApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductApplicationService productApplicationService;

    @PostMapping
    public ResponseEntity<Data<CreateProductResponse>> createProduct(@RequestBody CreateProduct createProduct){
        log.info("Creating product with name: {}", createProduct.getName());
        Data<CreateProductResponse> data = new Data<>(productApplicationService.createProduct(createProduct), "Product added, please upload product image!");
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/{productID}")
    public ResponseEntity<Data<GetProductResponse>> getProduct(@PathVariable("productID") UUID productID){
        GetProductResponse response = productApplicationService.getProduct(productID);
        if(response.getClass().getSimpleName().equalsIgnoreCase("productnotfoundresponse"))
            return new ResponseEntity<>(new Data<>(response, "Product not found"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new Data<>(response, "Product found"), HttpStatus.FOUND);
    }

    @PostMapping("/images/{productID}")
    public ResponseEntity<?> uploadProductImage(@PathVariable("productID") UUID productID,  @RequestParam("images") MultipartFile[] images){
        productApplicationService.uploadProductImage(productID, List.of(images));
        return ResponseEntity.ok("image uploaded successfully");
    }
}
