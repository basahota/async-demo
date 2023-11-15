package com.javatechie.async.controller;

import com.javatechie.async.dto.Order;
import com.javatechie.async.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderManagementController {
    @Autowired
    private OrderManagementService service;

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
        service.processOrder(order);
        service.assignVendor(order);
        service.packaging(order);
        service.assignDeliveryPartner(order);
        service.assignTrailer(order);
        service.dispatch(order);
        return ResponseEntity.ok(order);
    }
}
