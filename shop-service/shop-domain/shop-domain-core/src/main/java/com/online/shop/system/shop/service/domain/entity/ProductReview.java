package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.ProductID;
import com.online.shop.system.shop.service.domain.entity.base.ProductReviewID;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ProductReview extends BaseEntity<ProductReviewID> {
    private ProductID productID;
    private UserID userID;
    private String description;
    private InputStream video;
    private List<Byte[]> images;

}
