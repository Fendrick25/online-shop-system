package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class ProductFoundResponse extends GetProductResponse{
    @NotNull
    private final UUID productID;
    @NotNull
    private final String name;


    private final BigDecimal price;

    private List<byte[]> images;
    @NotNull
    private String description;
    @NotNull
    private double rating;
    @NotNull
    private ProductStatus status;
    @NotNull
    private int quantity;

}
