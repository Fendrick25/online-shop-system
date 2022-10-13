package com.online.shop.system.shop.service.domain.ports.input.service;

import com.online.shop.system.shop.service.domain.create.CreateProductReview;
import com.online.shop.system.shop.service.domain.create.response.GetProductReviewResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


public interface ProductReviewApplicationService {
    void createProductReview(CreateProductReview createProductReview);
    void uploadImageAndVideo(UUID productID, List<MultipartFile> images, List<MultipartFile> videos);
    GetProductReviewResponse getProductReview(UUID productID);

    void deleteProductReview(UUID productReviewID);
}
