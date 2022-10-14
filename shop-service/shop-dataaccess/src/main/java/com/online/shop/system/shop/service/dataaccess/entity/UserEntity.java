package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.entity.OrderItemE;
import com.online.shop.system.shop.service.domain.valueobject.Address;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private List<Address> addresses;

    @OneToMany
    private List<OrderItemE> orders;
}
