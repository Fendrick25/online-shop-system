package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.response.CreateProductResponse;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;
import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.exception.ShopDomainException;
import com.online.shop.system.shop.service.domain.mapper.ProductMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.ProductApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final ProductDomainService productDomainService;

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProduct createProduct) {
        Product product = productDomainService.validateProduct(productMapper.createProductToProduct(createProduct));
        productRepository.createProduct(product);
        return new CreateProductResponse(product.getId().getValue(), "Product created, please upload product image!");
    }

    @Override
    @Transactional(readOnly = true)
    public GetProductResponse getProduct(UUID productID) {
        Optional<Product> product = productRepository.getProduct(productID);
        if(product.isEmpty()){
            throw new ShopDomainException("Product not found!");
        }
        return new GetProductResponse(product.get());
    }
}
