package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.CreateProductReview;
import com.online.shop.system.shop.service.domain.create.response.GetProductReviewResponse;
import com.online.shop.system.shop.service.domain.entity.ProductReview;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewApplicationMapper {
    public ProductReview createProductReviewToProductReview(CreateProductReview createProductReview){
        return ProductReview.builder()
                .productID(new ProductID(createProductReview.getProductID()))
                .userID(new UserID(createProductReview.getUserID()))
                .description(createProductReview.getDescription())
                .rating(createProductReview.getRating())
                .build();
    }

    public GetProductReviewResponse productReviewToGetProductReviewResponse(ProductReview productReview){
        return GetProductReviewResponse.builder()
                .productID(productReview.getProductID().getValue())
                .userID(productReview.getUserID().getValue())
                .description(productReview.getDescription())
                .rating(productReview.getRating())
                .images(productReview.getImages())
                .videos(productReview.getImages())
                .build();
    }
}
