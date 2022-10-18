package com.online.shop.system.shop.service.domain.ports.input.service;

import java.util.UUID;

public interface TrackingApplicationService {
    void deliverOrder(UUID trackingID);
    void orderDelivered(UUID trackingID);
}
