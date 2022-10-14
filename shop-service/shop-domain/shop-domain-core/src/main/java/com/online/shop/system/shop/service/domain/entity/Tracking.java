package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.TrackingID;
import com.online.shop.system.shop.service.domain.valueobject.TrackingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tracking extends BaseEntity<TrackingID> {
    private TrackingStatus trackingStatus;

    public Tracking(TrackingID trackingID, TrackingStatus trackingStatus) {
        super.setId(trackingID);
        this.trackingStatus = trackingStatus;
    }
}
