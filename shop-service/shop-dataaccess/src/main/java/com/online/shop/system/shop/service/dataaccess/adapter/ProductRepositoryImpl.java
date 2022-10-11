package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductImageEntity;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.ProductDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.ProductImageJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.ProductJpaRepository;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductDataAccessMapper productMapper;

    @Override
    @Transactional
    public void createProduct(Product product) {
        productJpaRepository.save(productMapper.productToProductEntity(product));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProduct(UUID productID) {
        return Optional.ofNullable(productJpaRepository.findById(productID).map(productMapper::productEntityToProduct).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    public void uploadImage(UUID productID, List<MultipartFile> images) {
        Optional<ProductEntity> product = productJpaRepository.findById(productID);
        List<ProductImageEntity> productImageEntities = productMapper.multiPartFileToProductImageEntities(images);
        productImageEntities.forEach(productImageEntity -> productImageEntity.setProduct(product.get()));
        productImageJpaRepository.saveAll(productImageEntities);
    }

    @Override
    public void deleteProduct(UUID productID) {
        getProduct(productID);
        productJpaRepository.deleteById(productID);
    }
}
