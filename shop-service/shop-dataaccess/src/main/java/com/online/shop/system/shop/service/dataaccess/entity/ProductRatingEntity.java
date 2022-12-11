package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.entity.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product_ratings")
public class ProductRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
}
