package com.online.shop.system.shop.service.domain.ports.input.service;


import com.online.shop.system.shop.service.domain.create.CreateProduct;
import com.online.shop.system.shop.service.domain.create.UpdateProduct;
import com.online.shop.system.shop.service.domain.create.response.CreateProductResponse;
import com.online.shop.system.shop.service.domain.create.response.GetProductResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ProductApplicationService {
    CreateProductResponse createProduct(@Valid CreateProduct createProduct);
    GetProductResponse getProduct(UUID productID);
    void uploadProductImage(UUID productID, List<MultipartFile> images);
    void deleteProduct(UUID productID);
    void updateProduct(@Valid UpdateProduct updateProduct);
}
