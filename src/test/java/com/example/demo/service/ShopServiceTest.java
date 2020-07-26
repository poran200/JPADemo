package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ShopServiceTest {

    @Autowired
    private ShopService shopService;
    @Test
    void findByName() {
        var byName = shopService.findByName("shop-c");
        System.out.println("byName = " + byName.getId());
        assertEquals(3,byName.getId());
    }
}