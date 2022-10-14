package com.online.shop.system.shop.service.dataaccess.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private
}
