package com.example.demo.model;

import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ShopRepository;
import com.example.demo.repo.StockRepository;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ShopTest {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    @Autowired
    DemoService demoService;

   Logger logger = LoggerFactory.getLogger(ShopTest.class);
    @Test
    void createShop() {
        Shop shop = new Shop(3L,"shop-c",null);
        Shop saveShop = shopRepository.save(shop);
        assertEquals( shop.getId(),saveShop.getId());
    }

    @Test
    void addProduct() {
//        Product product = new Product(102L,"Orange",null);
        Product product = productRepository.getOne(102L);
        Product saveProduct = demoService.addProduct(3L,product);
        assertEquals(product.getId(),saveProduct.getId());
    }

    @Test
    void addStock() {
        Stock stock = new Stock(20L,8,null);
        Stock saveStock = demoService.createStock(3L, 102L, stock);
        assertEquals(stock.getId(), saveStock.getId());
        assertEquals(102,saveStock.getProduct().getId());
    }

    @Test
    void stockUpdate() {
        Stock stock = new Stock(28L,2,null);
        Stock updateStock = demoService.updateStock(28L, stock);
        assertEquals(10,updateStock.getQuantity());
    }

//    @Test
//    void getAllProduct() {
//        List<Product> productList =demoService.getAllProduct(2);
//        assertNotNull(productList);
//    }

}
