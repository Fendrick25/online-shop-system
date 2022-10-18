package com.online.shop.system.shop.service.domain.valueobject;

import com.online.shop.system.shop.service.domain.entity.base.UserID;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Address {
    @Setter
    private UserID userID;
    private final String street;
    private final String postalCode;
    private final String city;
}
