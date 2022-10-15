package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
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
    private TrackingStatus trackingStatus;

    @Builder
    public Tracking(TrackingID trackingID, TrackingStatus trackingStatus) {
        super.setId(trackingID);
        this.trackingStatus = trackingStatus;
    }

    public void onDelivery(){
      this.trackingStatus = TrackingStatus.ONDELIVERY;
    }

    public void delivered(){
        this.trackingStatus = TrackingStatus.DELIVERED;
    }

    public void initTracking(){
        setId(new TrackingID(new UUID(0,0)));
        this.trackingStatus = TrackingStatus.NOTVERIFIED;
    }
}
