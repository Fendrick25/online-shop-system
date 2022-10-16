package com.online.shop.system.shop.service.dataaccess.exception;


import com.online.shop.system.shop.service.domain.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ShopDataAccessException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
        List<String> details = new ArrayList<>();
        details.add(exception.getMessage());

        ApiError err = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .message("Data not found")
                .errors(details)
                .build();

        return new ResponseEntity<>(err, err.getStatus());
    }

    @ExceptionHandler(MoneyNotEqualException.class)
    public ResponseEntity<?> handleMoneyNotEqualException(MoneyNotEqualException exception){
        List<String> details = new ArrayList<>();
        details.add(exception.getMessage());

        ApiError err = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .message("Money not valid")
                .errors(details)
                .build();

        return new ResponseEntity<>(err, err.getStatus());
    }

}
