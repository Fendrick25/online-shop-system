package com.online.shop.system.shop.service.domain.service;

import com.online.shop.system.shop.service.domain.entity.Tracking;


public interface TrackingDomainService {
    void deliverOrder(Tracking tracking);
    void orderDelivered(Tracking tracking);
}
