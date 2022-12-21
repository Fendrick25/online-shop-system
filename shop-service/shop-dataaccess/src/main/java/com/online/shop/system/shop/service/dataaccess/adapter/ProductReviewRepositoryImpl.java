package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.ProductRatingEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductReviewEntity;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.ProductReviewDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.ProductJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.ProductRatingJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.ProductReviewMongoRepository;
import com.online.shop.system.shop.service.domain.entity.ProductReview;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductReviewRepositoryImpl implements ProductReviewRepository {

    private final ProductReviewDataAccessMapper productReviewDataAccessMapper;
    private final ProductReviewMongoRepository productReviewMongoRepository;

    private final ProductRatingJpaRepository productRatingJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Override
    @Transactional
    public void saveProductReview(ProductReview productReview) {
        productReviewMongoRepository.save(productReviewDataAccessMapper.productReviewToProductReviewEntity(productReview));
        ProductRatingEntity productRatingEntity = ProductRatingEntity.builder()
                .rating(productReview.getRating())
                .product(productJpaRepository.findById(productReview.getProductID().getValue()).orElseThrow(() -> new ResourceNotFoundException("Product not found")))
                .build();

        productRatingJpaRepository.save(productRatingEntity);
    }

    @Override
    @Transactional
    public void uploadImageAndVideo(UUID productID, List<MultipartFile> images, List<MultipartFile> videos) {
        Optional<ProductReviewEntity> productReviewEntity = getProductReviewByProductID(productID);
        productReviewEntity.get().setImages(productReviewDataAccessMapper.multiPartFilesToBinaryFiles(images));
        productReviewEntity.get().setVideos(productReviewDataAccessMapper.multiPartFilesToBinaryFiles(videos));
    }

    @Override
    @Transactional
    public ProductReview getProductReview(UUID productID) {
        return productReviewDataAccessMapper.productReviewEntityToProductReview(getProductReviewByProductID(productID).get());
    }

    @Override
    public void deleteProductReview(UUID productReviewID) {
        Optional<ProductReviewEntity> productReviewEntity = Optional.ofNullable(productReviewMongoRepository.findById(productReviewID).orElseThrow(() -> new ResourceNotFoundException("Product Review not found")));
        productReviewMongoRepository.deleteById(productReviewID);
    }

    private Optional<ProductReviewEntity> getProductReviewByProductID(UUID productID){
        return Optional.ofNullable(productReviewMongoRepository.findByProductID(productID).orElseThrow(() -> new ResourceNotFoundException("Data not found")));
    }

}
