package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.mapper.ProductMapper;
import com.online.shop.system.shop.service.dataaccess.repository.ProductJpaRepository;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void createProduct(Product product) {
        productJpaRepository.save(productMapper.productToProductEntity(product));
    }

    @Override
    public Optional<Product> getProduct(UUID productID) {
        return productJpaRepository.findById(productID).map(productMapper::productEntityToProduct);

    }
}
