package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.ProductReview;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ProductReviewRepository {
    void saveProductReview(ProductReview productReview);
    void uploadImageAndVideo(UUID productID, List<MultipartFile> images, List<MultipartFile> videos);
    ProductReview getProductReview(UUID productID);
    void deleteProductReview(UUID productReviewID);
}
