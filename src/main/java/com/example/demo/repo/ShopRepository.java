package com.example.demo.repo;

import com.example.demo.dto.ShopDto;
import com.example.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    ShopDto findByName(String name);

}
