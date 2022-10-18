package com.online.shop.system.shop.service.domain.mapper;

import com.online.shop.system.shop.service.domain.create.OrderAddress;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import org.springframework.stereotype.Component;

@Component
public class UserAddressApplicationMapper {

    public Address orderAddressToAddress(OrderAddress orderAddress){
        return Address.builder()
                .street(orderAddress.getStreet())
                .postalCode(orderAddress.getPostalCode())
                .city(orderAddress.getCity())
                .build();
    }
}
