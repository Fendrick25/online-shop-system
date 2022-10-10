package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class ProductEntity {

    @Id
    private UUID id;
    private String name;
    private BigDecimal price;
    private String description;
    private double rating;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImageEntity> productImages;
}
