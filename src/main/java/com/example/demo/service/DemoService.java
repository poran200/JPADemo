package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.model.Stock;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ShopRepository;
import com.example.demo.repo.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class DemoService {
    final
    ShopRepository shopRepository;
    final
    ProductRepository productRepository;
    final
    StockRepository stockRepository;

    public DemoService(ShopRepository shopRepository, ProductRepository productRepository, StockRepository stockRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    public Product addProduct( long shopId, Product product){
        Shop shop = shopRepository.getOne(shopId);
        shop.addProduct(product);
        return productRepository.save(product);
    }


    public Stock createStock(long shopId, long productId, Stock stock){
        Shop shop = shopRepository.getOne(shopId);
        Product product = productRepository.getOne(productId);
        stock.setShop(shop);

        product.addStock(stock);
        stock.setProduct(product);

        Stock saveStock = stockRepository.save(stock);
        productRepository.save(product);
     return saveStock;
    }

    public  Stock  updateStock(long sockId,Stock stock){
        Stock getStock = stockRepository.getOne(sockId);
         stock.setId(getStock.getId());
         stock.setShop(getStock.getShop());
         stock.setQuantity(getStock.getQuantity() + stock.getQuantity());
        return stockRepository.save(stock);
    }


    public List<Product> getAllProduct(long shopId){
        return shopRepository.getOne(shopId).getProductList();
     }

     public Map<Shop, List<Product>> getProductByMap(long shopId){
        Map<Shop,  List<Product>> shpoPrudctMap = new HashMap<>();
         Shop shop = shopRepository.getOne(shopId);
         List<Product> productList = shop.getProductList();
         shpoPrudctMap.put(shop,productList);
         return shpoPrudctMap;
     }

     public Map<Long, List<Stock>> getProductWithStock (long shopId){
         Map<Long, List<Stock>> productListMap = new HashMap<>();
         List<Product> productList = shopRepository.getOne(shopId).getProductList();
          productList.forEach(product -> productListMap.put(product.getId(), product.getStockList().
                  stream().filter(stock -> stock.getShop().getId()== shopId)
                  .collect(Collectors.toList())));
          return productListMap;
     }
}
