package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.warehouse.WareHouse;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.WareHouseRepository;
import com.example.demo.service.WareHouseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WareHouseIntegrationTest {
    @Autowired
    private WareHouseService wareHouseService;
    @Autowired
    private  WareHouseRepository wareHouseRepository;

    @Autowired
    private  ProductRepository productRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createWareHouse() {
      var wareHouse = new WareHouse(1, "Nikonja 2", null);
      var save = wareHouseRepository.save(wareHouse);
      assertEquals(wareHouse.getWareHouseId(),save.getWareHouseId());
    }
  @Test
  void addProduct() {
    var product = new Product(1, "milk", null, null);
    var save =wareHouseService.update(1,product);
    assertEquals(1,save.getWareHouseId());
  }

  @Test
  void deleteById() {
    assertTrue(wareHouseService.deleteById(1));
  }

  @Test
  void deleteProduct() {
    var product = new Product(1, "milk", null, null);
    var wareHouse = wareHouseService.deleteProduct(1, product);
    assertEquals(0,wareHouse.getProducts().size());
  }



}
