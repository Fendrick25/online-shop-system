package com.online.shop.system.shop.service.domain.create.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetProductReviewResponse {
    @NotNull
    private final UUID productID;
    @NotNull
    private final UUID userID;
    @NotNull
    private final String description;
    @NotNull
    private final int rating;
    @NotNull
    private final List<byte[]> images;
    @NotNull
    private final List<byte[]> videos;
}