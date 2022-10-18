package com.online.shop.system.shop.service.dataaccess.mapper;

import com.online.shop.system.shop.service.dataaccess.entity.TrackingEntity;
import com.online.shop.system.shop.service.domain.entity.Tracking;
import com.online.shop.system.shop.service.domain.entity.base.OrderID;
import com.online.shop.system.shop.service.domain.entity.base.TrackingID;
import org.springframework.stereotype.Component;

@Component
public class TrackingDataAccessMapper {

    public Tracking trackingEntityToTracking(TrackingEntity trackingEntity){
        return Tracking.builder()
                .orderID(new OrderID(trackingEntity.getOrder().getId()))
                .trackingID(new TrackingID(trackingEntity.getId()))
                .trackingStatus(trackingEntity.getTrackingStatus())
                .build();
    }

}
