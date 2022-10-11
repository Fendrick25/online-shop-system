package com.online.shop.system.shop.service;

import com.online.shop.system.shop.service.domain.OrderDomainService;
import com.online.shop.system.shop.service.domain.OrderDomainServiceImpl;
import com.online.shop.system.shop.service.domain.ProductDomainService;
import com.online.shop.system.shop.service.domain.ProductDomainServiceImpl;
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
}
