package com.online.shop.system.shop.service.domain.ports.output.repository;


import java.util.UUID;

public interface TrackingRepository{

    void deliverOrder(UUID trackingID);
    void orderDelivered(UUID trackingID);
}
