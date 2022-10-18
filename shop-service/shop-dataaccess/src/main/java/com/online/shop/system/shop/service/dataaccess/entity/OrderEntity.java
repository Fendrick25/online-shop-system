package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.valueobject.Address;
import com.online.shop.system.shop.service.domain.valueobject.OrderStatus;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OrderEntity {

    @Id
    private UUID id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Address deliveryAddress;

    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_id", referencedColumnName = "id")
    private TrackingEntity tracking;


    private ZonedDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
