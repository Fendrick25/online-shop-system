package com.online.shop.system.shop.service.dataaccess.exception;

public class ShopDataAccessException extends RuntimeException {
    public ShopDataAccessException(String message) {
        super(message);
    }

    public ShopDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
