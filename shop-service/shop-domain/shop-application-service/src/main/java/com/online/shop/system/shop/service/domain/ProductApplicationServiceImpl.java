package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.UpdateProduct;
import com.online.shop.system.shop.service.domain.create.response.CreateProductResponse;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.mapper.ProductApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.ProductApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductRepository productRepository;
    private final ProductApplicationMapper productMapper;
    private final ProductDomainService productDomainService;

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProduct createProduct) {
        Product product = productDomainService.validateProduct(productMapper.createProductToProduct(createProduct));
        productRepository.createProduct(product);
        return new CreateProductResponse(product.getId().getValue());
    }

    @Override
    public GetProductResponse getProduct(UUID productID) {
        return productMapper.productToGetProductResponse(productRepository.getProduct(productID).get());
    }

    @Override
    public void uploadProductImage(UUID productID, List<MultipartFile> images) {
        productRepository.uploadImage(productID, images);
    }

    @Override
    public void deleteProduct(UUID productID) {
        productRepository.deleteProduct(productID);
    }

    @Override
    public void updateProduct(UpdateProduct updateProduct) {
        Product product = productMapper.updateProductToProduct(updateProduct);
        productRepository.updateProduct(product);
    }
}
