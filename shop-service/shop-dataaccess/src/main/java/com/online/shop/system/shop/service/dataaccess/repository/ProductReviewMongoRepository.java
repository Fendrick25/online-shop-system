package com.online.shop.system.shop.service.dataaccess.repository;

import com.online.shop.system.shop.service.dataaccess.entity.ProductReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductReviewMongoRepository extends MongoRepository<ProductReviewEntity, UUID> {
    Optional<ProductReviewEntity> findByProductID(UUID productID);
}
