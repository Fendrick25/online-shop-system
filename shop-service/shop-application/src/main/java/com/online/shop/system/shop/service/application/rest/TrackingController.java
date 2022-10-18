package com.online.shop.system.shop.service.application.rest;

import com.online.shop.system.shop.service.domain.ports.input.service.TrackingApplicationService;
import com.online.shop.system.shop.service.domain.create.response.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tracking")
public class TrackingController {

    private final TrackingApplicationService trackingApplicationService;

    @PatchMapping("/deliver/{trackingID}")
    public ResponseEntity<?> deliverOrder(@PathVariable("trackingID") UUID trackingID){
        trackingApplicationService.deliverOrder(trackingID);
        return new ResponseEntity<>(new Data<String>("Order with tracking id: " + trackingID + " is on delivery", "Order on delivery"), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/completed/{trackingID}")
    public ResponseEntity<?> orderDelivered(@PathVariable("trackingID") UUID trackingID){
        trackingApplicationService.orderDelivered(trackingID);
        return new ResponseEntity<>(new Data<String>("Order with tracking id: " + trackingID + " is delivered", "Order delivered"), HttpStatus.ACCEPTED);
    }
}
