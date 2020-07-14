package com.example.demo.service;

import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.WareHouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProductService {

    private  final ProductRepository productRepository;
    private final WareHouseRepository wareHouseRepository;

    public ProductService(ProductRepository productRepository, WareHouseRepository wareHouseRepository) {
        this.productRepository = productRepository;
        this.wareHouseRepository = wareHouseRepository;
    }


    public boolean delete(long id){
        var optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            var product = optionalProduct.get();
            product.getWareHouses().forEach(wareHouse -> wareHouse.remove(product));
            productRepository.deleteById(id);
            return true;
        }else {
            throw  new EntityNotFoundException(""+id);
        }
    }

}
