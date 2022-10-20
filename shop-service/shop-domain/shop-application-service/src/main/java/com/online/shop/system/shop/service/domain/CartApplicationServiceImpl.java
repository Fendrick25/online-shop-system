package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.OrderItem;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.create.response.GetCartResponse;
import com.online.shop.system.shop.service.domain.entity.Cart;
import com.online.shop.system.shop.service.domain.entity.CartItemE;
import com.online.shop.system.shop.service.domain.mapper.CartApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.CartApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.CartRepository;
import com.online.shop.system.shop.service.domain.service.CartDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;


@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class CartApplicationServiceImpl implements CartApplicationService {

    private final CartRepository cartRepository;
    private final CartDomainService cartDomainService;
    private final CartApplicationMapper cartApplicationMapper;

    @Override
    public AddToCartResponse addToCart(AddToCart addToCart) {
        CartItemE cartItem = cartApplicationMapper.addToCartToCartItem(addToCart);
        cartDomainService.addToCart(cartItem);
        cartRepository.addToCart(cartItem);
        return new AddToCartResponse(cartItem.getId().getValue());
    }

    @Override
    public GetCartResponse getCart(UUID cartID) {
        return cartApplicationMapper.cartToGetCartResponse(cartRepository.getCart(cartID));
    }

    @Override
    public String deleteCartItem(UUID cartItemID) {
        cartRepository.deleteCartItem(cartItemID);
        return "Cart item with productID: " + cartItemID + " deleted";
    }

    @Override
    public String updateCartItem(UUID cartItemID, OrderItem orderItem) {
        cartRepository.updateCartItem(cartItemID, orderItem);
        return "Cart item with productID: " + cartItemID + " updated";
    }
}
