package com.javatechie.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class InventoryService {

    public boolean checkProductAvailability(int productId) {
        boolean isProductAvailable = new Random().nextBoolean();
        log.info("is product available " + productId);
        return isProductAvailable;
    }
}
