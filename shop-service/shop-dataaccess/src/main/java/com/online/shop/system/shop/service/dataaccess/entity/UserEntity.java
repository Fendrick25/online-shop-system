package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.valueobject.Address;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID", referencedColumnName = "id")
    private CartEntity cart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
