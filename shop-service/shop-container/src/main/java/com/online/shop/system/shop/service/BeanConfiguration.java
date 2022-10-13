package com.online.shop.system.shop.service;

import com.online.shop.system.shop.service.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }

    @Bean
    public ProductDomainService productDomainService(){
        return new ProductDomainServiceImpl();
    }

    @Bean
    public ProductReviewDomainService productReviewDomainService(){
        return new ProductReviewDomainServiceImpl();
    }
}
