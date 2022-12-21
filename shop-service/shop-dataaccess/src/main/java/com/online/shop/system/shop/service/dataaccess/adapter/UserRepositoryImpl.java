package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.AddressEntity;
import com.online.shop.system.shop.service.dataaccess.entity.UserEntity;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.UserAddressDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.mapper.UserDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.UserAddressJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.UserJpaRepository;
import com.online.shop.system.shop.service.domain.entity.User;
import com.online.shop.system.shop.service.domain.ports.output.repository.UserRepository;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    private final UserAddressJpaRepository userAddressJpaRepository;
    private final UserAddressDataAccessMapper userAddressDataAccessMapper;

    @Override
    public void createUser(User user) {
        userJpaRepository.save(userDataAccessMapper.userToUserEntity(user));
    }

    @Override
    public void addAddress(Address address) {
        AddressEntity addressEntity = userAddressDataAccessMapper.addressToAddressEntity(address);
        addressEntity.setUser(userJpaRepository.findById(address.getUserID().getValue()).orElseThrow(() -> new ResourceNotFoundException("User not found!")));
        userAddressJpaRepository.save(addressEntity);
    }

    @Override
    public void deleteAddress(UUID addressID) {
        userAddressJpaRepository.findById(addressID).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        userAddressJpaRepository.deleteById(addressID);
    }

    @Override
    @Transactional
    public void updateAddress(UUID addressID, Address address) {
        AddressEntity addressEntity = userAddressJpaRepository.findById(addressID).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        addressEntity.setStreet(address.getStreet());
        addressEntity.setPostalCode(address.getPostalCode());
        addressEntity.setCity(address.getCity());
    }

}
