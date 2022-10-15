package com.online.shop.system.shop.service.dataaccess.repository;

import com.online.shop.system.shop.service.dataaccess.entity.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingJpaRepository extends JpaRepository<TrackingEntity, UUID> {
}
