package com.online.shop.system.shop.service.dataaccess.entity;

import com.online.shop.system.shop.service.domain.valueobject.TrackingStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tracking")
public class TrackingEntity {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TrackingStatus trackingStatus;

    @OneToOne(mappedBy = "tracking")
    private OrderEntity order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingEntity that = (TrackingEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
