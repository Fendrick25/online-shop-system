package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.CartEntity;
import com.online.shop.system.shop.service.dataaccess.entity.CartItemEntity;
import com.online.shop.system.shop.service.dataaccess.entity.ProductEntity;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.CartDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.CartItemJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.CartJpaRepository;
import com.online.shop.system.shop.service.dataaccess.repository.ProductJpaRepository;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.entity.Cart;
import com.online.shop.system.shop.service.domain.entity.CartItemE;
import com.online.shop.system.shop.service.domain.ports.output.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepository {

    private final CartJpaRepository cartJpaRepository;
    private final CartItemJpaRepository cartItemJpaRepository;
    private final CartDataAccessMapper cartDataAccessMapper;
    private final ProductJpaRepository productJpaRepository;

    @Override
    @Transactional
    public void addToCart(CartItemE cartItem) {
        CartItemEntity cartItemEntity = cartDataAccessMapper.cartItemToCartItemEntity(cartItem);
        ProductEntity productEntity = productJpaRepository.findById(cartItem.getItem().getProduct().getId().getValue()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Optional<CartItemEntity> optionalCartItemEntity = cartItemJpaRepository.findByCartIDAndProductID(cartItem.getCartID().getValue(), cartItem.getItem().getProduct().getId().getValue());
        if(optionalCartItemEntity.isPresent()){
            optionalCartItemEntity.get().setQuantity(optionalCartItemEntity.get().getQuantity() + cartItemEntity.getQuantity());
            optionalCartItemEntity.get().setSubTotal(optionalCartItemEntity.get().getSubTotal().add(cartItemEntity.getSubTotal()));
            cartItemJpaRepository.save(optionalCartItemEntity.get());
        }

        if(optionalCartItemEntity.isEmpty()){
            CartEntity cartEntity = cartJpaRepository.getReferenceById(cartItem.getCartID().getValue());
            cartItemEntity.setCart(cartEntity);
            cartItemEntity.setProduct(productEntity);
            cartItemJpaRepository.save(cartItemEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Cart getCart(UUID cartID) {
        return cartJpaRepository.findById(cartID).map(cartDataAccessMapper::cartEntityToCart).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    @Transactional
    public void deleteCartItem(UUID cartItemID) {
        cartItemJpaRepository.findById(cartItemID).orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
        cartItemJpaRepository.deleteById(cartItemID);
    }

    @Override
    @Transactional
    public void updateCartItem(UUID cartItemID, OrderItem orderItem) {
        CartItemEntity cartItemEntity = cartItemJpaRepository.findById(cartItemID).orElseThrow(() -> new ResourceNotFoundException("Product not found in cart!"));
        cartItemEntity.setQuantity(orderItem.getQuantity());
        cartItemEntity.setSubTotal(orderItem.getSubTotal());
        cartItemJpaRepository.save(cartItemEntity);
    }

}
