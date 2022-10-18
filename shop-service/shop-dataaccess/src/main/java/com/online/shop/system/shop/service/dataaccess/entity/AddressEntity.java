package com.online.shop.system.shop.service.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String street;
    private String postalCode;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
