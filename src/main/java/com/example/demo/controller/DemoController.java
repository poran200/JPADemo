package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.repo.ShopRepository;
import com.example.demo.repo.StockRepository;
import com.example.demo.service.DemoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    public DemoService demoService;

//    @GetMapping(value = "/getproduct/{shopId}")
//    public List<Product> getAllProduct(@PathVariable long shopId){
//        return getProducts(shopId);
//    }
//    public List<Product> getAllProductPage(@PathVariable long shopId){
//
//        return getProducts(shopId);
//    }

    @GetMapping(value = "getproduct/{shopId}")
    @NotNull
    public ResponseEntity<Object> getProducts(@PathVariable long shopId, HttpServletRequest  request) {
        try{
            var productWithStock = demoService.getProductWithStock(shopId);
            return ResponseEntity.status(HttpStatus.OK).body(productWithStock);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @GetMapping(value = "/getAllStock")
    public List<Stock> getAllStock(Pageable pageable){
        return stockRepository.findAll()
                .stream()
                .filter(stock -> stock.getShop().getId()== 2)
                .collect(Collectors.toList());
    }
}
