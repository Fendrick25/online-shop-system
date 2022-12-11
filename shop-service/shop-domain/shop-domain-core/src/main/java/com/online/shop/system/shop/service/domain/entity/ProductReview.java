package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Getter
public class ProductReview extends BaseEntity<ProductReviewID> {
    private final ProductID productID;
    private final UserID userID;
    private final String description;

    private final int rating;
    @Setter
    private List<byte[]> videos;
    @Setter
    private List<byte[]> images;

    @Builder
    public ProductReview(ProductReviewID productReviewID, ProductID productID, UserID userID, String description, int rating, List<byte[]> videos, List<byte[]> images) {
        super.setId(productReviewID);
        this.productID = productID;
        this.userID = userID;
        this.description = description;
        this.rating = rating;
        this.videos = videos;
        this.images = images;
    }

    public void initializeProductReview(){
        //Todo: validation
        setId(new ProductReviewID(UUID.randomUUID()));
    }
}
