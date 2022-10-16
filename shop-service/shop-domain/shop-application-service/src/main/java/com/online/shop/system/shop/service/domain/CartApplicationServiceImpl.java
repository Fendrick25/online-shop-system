package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.create.AddToCart;
import com.online.shop.system.shop.service.domain.create.response.AddToCartResponse;
import com.online.shop.system.shop.service.domain.entity.CartItem;
import com.online.shop.system.shop.service.domain.mapper.CartApplicationMapper;
import com.online.shop.system.shop.service.domain.ports.input.service.CartApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.CartRepository;
import com.online.shop.system.shop.service.domain.service.CartDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class CartApplicationServiceImpl implements CartApplicationService {

    private final CartRepository cartRepository;
    private final CartDomainService cartDomainService;
    private final CartApplicationMapper cartApplicationMapper;

    @Override
    @Transactional
    public AddToCartResponse addToCart(AddToCart addToCart) {
        CartItem cartItem = cartApplicationMapper.addToCartToCartItem(addToCart);
        cartDomainService.addToCart(cartItem);
        cartRepository.addToCart(cartItem);
        return new AddToCartResponse(cartItem.getCartID().getValue());
    }
}
