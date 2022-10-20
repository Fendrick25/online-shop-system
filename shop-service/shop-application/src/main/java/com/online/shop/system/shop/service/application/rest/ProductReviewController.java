package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.create.CreateProductReview;
import com.online.shop.system.shop.service.domain.create.response.Data;
import com.online.shop.system.shop.service.domain.create.response.GetProductReviewResponse;
import com.online.shop.system.shop.service.domain.ports.input.service.ProductReviewApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/products/reviews")
@RequiredArgsConstructor
public class ProductReviewController {

    private final ProductReviewApplicationService productReviewApplicationService;

    @PostMapping
    public ResponseEntity<?> createProductReview(@RequestBody CreateProductReview createProductReview){
        productReviewApplicationService.createProductReview(createProductReview);
        return ResponseEntity.ok("product review uploaded");
    }

    @PatchMapping("/{productID}")
    public ResponseEntity<?> uploadImageAndVideo(@PathVariable("productID") UUID productID,  @RequestParam("images") MultipartFile[] images, @RequestParam("videos") MultipartFile[] videos){
        productReviewApplicationService.uploadImageAndVideo(productID, List.of(images), List.of(videos));
        return ResponseEntity.ok("Product review contents uploaded");
    }

    @GetMapping("/{productID}")
    public ResponseEntity<Data<GetProductReviewResponse>> getProductReview(@PathVariable("productID") UUID productID){
        return new ResponseEntity<>(new Data<>( productReviewApplicationService.getProductReview(productID), "Product review found!"), HttpStatus.OK);
    }

    @DeleteMapping("/{productReviewID}")
    public ResponseEntity<?> deleteProductReview(@PathVariable("productReviewID") UUID productReviewID){
        productReviewApplicationService.deleteProductReview(productReviewID);
        return new ResponseEntity<>("Product review deleted", HttpStatus.OK);
    }

}
