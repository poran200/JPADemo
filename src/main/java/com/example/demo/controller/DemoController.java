package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Stock;
import com.example.demo.repo.ShopRepository;
import com.example.demo.repo.StockRepository;
import com.example.demo.service.DemoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
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

    @GetMapping(value = "/getproduct/{shopId}")
    @NotNull
    private List<Product> getProducts(@PathVariable long shopId) {
        List<Product> productList = demoService.getAllProduct(shopId);
        productList.forEach( product -> {
            List<Stock> collect = product.getStockList().stream()
                    .filter(stock -> stock.getShop().getId() == shopId)
                    .collect(Collectors.toList());
            product.setStockList(collect);
        });
        return  productList;
    }

    @GetMapping(value = "/getAllStock")
    public List<Stock> getAllStock(Pageable pageable){
        return stockRepository.findAll()
                .stream()
                .filter(stock -> stock.getShop().getId()== 2)
                .collect(Collectors.toList());
    }
}
