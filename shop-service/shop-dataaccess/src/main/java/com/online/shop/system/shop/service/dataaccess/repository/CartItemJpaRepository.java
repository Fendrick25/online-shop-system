package com.online.shop.system.shop.service.dataaccess.repository;

import com.online.shop.system.shop.service.dataaccess.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, UUID> {

    @Query("SELECT u FROM CartItemEntity u WHERE u.cart.id = ?1 AND u.product.id = ?2")
    Optional<CartItemEntity> findByCartIDAndProductID(UUID cartID, UUID productID);
}
