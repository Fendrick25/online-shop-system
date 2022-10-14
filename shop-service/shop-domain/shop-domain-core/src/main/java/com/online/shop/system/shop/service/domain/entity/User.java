package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.AggregateRoot;
import com.online.shop.system.shop.service.domain.entity.base.UserID;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class User extends AggregateRoot<UserID> {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private List<Address> userAddresses;
    private List<Order> orders;

    private List<ProductReview> productReviews;

    @Builder
    public User(UserID userID, String username, String password, String email, String phoneNumber, List<Address> userAddresses, List<Order> orders, List<ProductReview> productReviews) {
        super.setId(userID);
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userAddresses = userAddresses;
        this.orders = orders;
        this.productReviews = productReviews;
    }

    public void initializeUser(){
        setId(new UserID(UUID.randomUUID()));
    }


}
