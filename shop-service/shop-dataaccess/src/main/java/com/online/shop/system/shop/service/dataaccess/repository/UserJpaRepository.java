package com.online.shop.system.shop.service.dataaccess.repository;

import com.online.shop.system.shop.service.dataaccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
}
