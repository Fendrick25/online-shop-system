package com.online.shop.system.shop.service.dataaccess.repository;

import com.online.shop.system.shop.service.dataaccess.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAddressJpaRepository extends JpaRepository<AddressEntity, UUID> {
}
