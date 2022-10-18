package com.online.shop.system.shop.service.domain;

import com.online.shop.system.shop.service.domain.entity.Tracking;
import com.online.shop.system.shop.service.domain.ports.input.service.TrackingApplicationService;
import com.online.shop.system.shop.service.domain.ports.output.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class TrackingApplicationServiceImpl implements TrackingApplicationService {
    private final TrackingRepository trackingRepository;
    @Override
    public void deliverOrder(UUID trackingID) {
        trackingRepository.deliverOrder(trackingID);
    }

    @Override
    public void orderDelivered(UUID trackingID) {
        trackingRepository.orderDelivered(trackingID);
    }

}
