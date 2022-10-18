package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.TrackingID;
import com.online.shop.system.shop.service.domain.valueobject.TrackingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Tracking extends BaseEntity<TrackingID> {

    private OrderID orderID;
    private TrackingStatus trackingStatus;

    @Builder
    public Tracking(TrackingID trackingID, OrderID orderID, TrackingStatus trackingStatus) {
        super.setId(trackingID);
        this.orderID = orderID;
        this.trackingStatus = trackingStatus;
    }

    public void initTracking(){
        setId(new TrackingID(UUID.randomUUID()));
        this.trackingStatus = TrackingStatus.NOTVERIFIED;
    }
}
