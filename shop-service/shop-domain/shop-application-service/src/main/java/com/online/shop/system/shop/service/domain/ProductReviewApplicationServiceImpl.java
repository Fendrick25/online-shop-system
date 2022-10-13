package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateProductReview;
import com.online.shop.system.shop.service.domain.create.response.GetProductReviewResponse;
import com.online.shop.system.shop.service.domain.entity.ProductReview;
import com.online.shop.system.shop.service.domain.mapper.ProductReviewApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.ProductReviewApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class ProductReviewApplicationServiceImpl implements ProductReviewApplicationService {

    private final ProductReviewRepository productReviewRepository;
    private final ProductReviewApplicationMapper productReviewMapper;
    private final ProductReviewDomainService productReviewDomainService;

    @Override
    public void createProductReview(CreateProductReview createProductReview) {
        ProductReview productReview = productReviewDomainService.validateProductReview(productReviewMapper.createProductReviewToProductReview(createProductReview));
        productReviewRepository.saveProductReview(productReview);
    }

    @Override
    public void uploadImageAndVideo(UUID productID, List<MultipartFile> images, List<MultipartFile> videos) {
        productReviewRepository.uploadImageAndVideo(productID, images, videos);
    }

    @Override
    public GetProductReviewResponse getProductReview(UUID productID) {
        return productReviewMapper.productReviewToGetProductReviewResponse(productReviewRepository.getProductReview(productID));
    }

    @Override
    public void deleteProductReview(UUID productReviewID) {
        productReviewRepository.deleteProductReview(productReviewID);
    }
}
