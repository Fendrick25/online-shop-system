package com.online.shop.system.shop.service.dataaccess.entity;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "product_review")
public class ProductReviewEntity {

    @Id
    private UUID id;
    private UUID userID;
    private UUID productID;
    private String description;
    private int rating;
    private List<byte[]> images;
    private List<byte[]> videos;

}
