package com.online.shop.system.shop.service.dataaccess.adapter;

import com.online.shop.system.shop.service.dataaccess.entity.TrackingEntity;
import com.online.shop.system.shop.service.dataaccess.exception.ResourceNotFoundException;
import com.online.shop.system.shop.service.dataaccess.mapper.TrackingDataAccessMapper;
import com.online.shop.system.shop.service.dataaccess.repository.TrackingJpaRepository;
import com.online.shop.system.shop.service.domain.entity.Tracking;
import com.online.shop.system.shop.service.domain.ports.output.repository.TrackingRepository;
import com.online.shop.system.shop.service.domain.valueobject.TrackingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TrackingRepositoryImpl implements TrackingRepository{

    private final TrackingJpaRepository trackingJpaRepository;

    @Override
    public void deliverOrder(UUID trackingID) {
        TrackingEntity trackingEntity = findTracking(trackingID);
        trackingEntity.setTrackingStatus(TrackingStatus.ONDELIVERY);
        trackingJpaRepository.save(trackingEntity);
    }

    @Override
    public void orderDelivered(UUID trackingID) {
        TrackingEntity trackingEntity = findTracking(trackingID);
        trackingEntity.setTrackingStatus(TrackingStatus.DELIVERED);
        trackingJpaRepository.save(trackingEntity);
    }

    private TrackingEntity findTracking(UUID trackingID){
        return trackingJpaRepository.findById(trackingID).orElseThrow(() -> new ResourceNotFoundException("Tracking with id " + trackingID + " not found"));
    }
}
