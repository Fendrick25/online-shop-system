package com.online.shop.system.shop.service.domain.exception;

public class ShopDomainException extends RuntimeException{
    public ShopDomainException(String message) {
        super(message);
    }

    public ShopDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
