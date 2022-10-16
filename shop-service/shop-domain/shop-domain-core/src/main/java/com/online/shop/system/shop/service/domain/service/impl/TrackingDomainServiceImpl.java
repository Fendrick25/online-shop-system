package com.online.shop.system.shop.service.domain.service.impl;

import com.online.shop.system.shop.service.domain.entity.Order;
import com.online.shop.system.shop.service.domain.entity.Tracking;
import com.online.shop.system.shop.service.domain.service.TrackingDomainService;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class TrackingDomainServiceImpl implements TrackingDomainService {

    @Override
    public void deliverOrder(Tracking tracking) {
        log.info("");
    }

    @Override
    public void orderDelivered(Tracking tracking) {

    }
}
