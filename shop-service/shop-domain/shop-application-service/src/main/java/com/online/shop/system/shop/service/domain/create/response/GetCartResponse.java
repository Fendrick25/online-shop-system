package com.online.shop.system.shop.service.domain.create.response;

import com.online.shop.system.shop.service.domain.create.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetCartResponse {
    @NotNull
    private final UUID cartID;
    @NotNull
    private final UUID userID;
    private List<CartItem> cartItems;
}
