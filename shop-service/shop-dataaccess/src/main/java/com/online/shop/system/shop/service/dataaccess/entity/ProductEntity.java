package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.entity.Product;
import com.online.shop.system.shop.service.domain.valueobject.ProductStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<OrderItemEntity> orderItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItem;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductRatingEntity> ratingsLog;

    public void mapUpdateProduct(Product product){
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice().getAmount();
        this.quantity = product.getQuantity();
        this.productStatus = product.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id.equals(that.id) && Objects.equals(productImages, that.productImages) && Objects.equals(orderItems, that.orderItems) && Objects.equals(cartItem, that.cartItem) && Objects.equals(ratingsLog, that.ratingsLog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productImages, orderItems, cartItem, ratingsLog);
    }
}
