package com.example.demo.service;

import com.example.demo.dto.ShopDto;
import com.example.demo.repo.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopDto findByName(String name){
       return shopRepository.findByName(name);
    }
}
