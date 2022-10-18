package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.AddressEntity;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import org.springframework.stereotype.Component;

@Component
public class UserAddressDataAccessMapper {

    public AddressEntity addressToAddressEntity(Address address){
        return AddressEntity.builder()
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .build();
    }

    public Address addressEntityToAddress(AddressEntity addressEntity){
        return Address.builder()
                .userID(new UserID(addressEntity.getUser().getId()))
                .street(addressEntity.getStreet())
                .postalCode(addressEntity.getPostalCode())
                .city(addressEntity.getPostalCode())
                .build();
    }
}
