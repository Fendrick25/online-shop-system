package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.ProductReviewEntity;
import com.online.shop.system.shop.service.domain.entity.ProductReview;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductReviewDataAccessMapper {

    public ProductReviewEntity productReviewToProductReviewEntity(ProductReview productReview){
        return ProductReviewEntity.builder()
                .id(productReview.getId().getValue())
                .productID(productReview.getProductID().getValue())
                .userID(productReview.getUserID().getValue())
                .description(productReview.getDescription())
                .rating(productReview.getRating())
                .build();

    }

    public ProductReview productReviewEntityToProductReview(ProductReviewEntity productReviewEntity){
        return ProductReview.builder()
                .productID(new ProductID(productReviewEntity.getProductID()))
                .userID(new UserID(productReviewEntity.getUserID()))
                .description(productReviewEntity.getDescription())
                .rating(productReviewEntity.getRating())
                .images(productReviewEntity.getImages())
                .videos(productReviewEntity.getVideos())
                .build();

    }

    public List<byte[]> multiPartFilesToBinaryFiles(List<MultipartFile> files){
        return files.stream().map(file -> {
                    try {
                        return file.getBytes();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}
