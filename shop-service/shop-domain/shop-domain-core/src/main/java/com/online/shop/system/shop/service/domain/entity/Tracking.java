package com.online.shop.system.shop.service.domain.entity;

import com.online.shop.system.shop.service.domain.entity.base.BaseEntity;
import com.online.shop.system.shop.service.domain.entity.base.TrackingID;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tracking extends BaseEntity<TrackingID> {
    private List<String> description;

    public Tracking(TrackingID trackingID, List<String> description) {
        super.setId(trackingID);
        this.description = description;
    }
}
