package com.online.shop.system.shop.service.domain.ports.output.repository;

import com.online.shop.system.shop.service.domain.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void createProduct(Product product);
    Optional<Product> getProduct(UUID productID);

    void uploadImage(UUID productID, List<MultipartFile> images);

}
