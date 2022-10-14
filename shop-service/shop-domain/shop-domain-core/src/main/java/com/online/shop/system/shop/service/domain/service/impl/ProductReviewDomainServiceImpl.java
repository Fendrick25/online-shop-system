package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.ProductReview;
import com.online.shop.system.shop.service.domain.service.ProductReviewDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductReviewDomainServiceImpl implements ProductReviewDomainService {

    @Override
    public ProductReview validateProductReview(ProductReview productReview) {
        productReview.initializeProductReview();
        log.info("Product review with id: {} initialized", productReview.getId().getValue());
        return productReview;
    }
}
