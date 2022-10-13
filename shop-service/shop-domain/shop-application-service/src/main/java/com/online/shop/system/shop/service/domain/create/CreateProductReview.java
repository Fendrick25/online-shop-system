package com.online.shop.system.shop.service.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
public class CreateProductReview {
    @NotNull
    private final UUID productID;
    @NotNull
    private final UUID userID;
    @NotNull
    private final String description;
    @NotNull
    @Min(1)
    @Max(5)
    private final int rating;
}
