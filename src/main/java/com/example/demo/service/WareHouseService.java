package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.warehouse.WareHouse;
import com.example.demo.repo.WareHouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class WareHouseService {
    final WareHouseRepository wareHouseRepository;

    public WareHouseService(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }

    public WareHouse update(int warehouseId, Product product){
        var wareHouseOptional = wareHouseRepository.findById(warehouseId);
        if (wareHouseOptional.isPresent()){
            wareHouseOptional.get().addProduct(product);
            return wareHouseRepository.save(wareHouseOptional.get());
        }
        throw new EntityNotFoundException(warehouseId+"");
    }

    public boolean deleteById(int id){
        var wareHouseOptional = wareHouseRepository.findById(id);
        if (wareHouseOptional.isPresent()){
            wareHouseRepository.delete(wareHouseOptional.get());
            return true;
        }else {
            throw  new EntityNotFoundException(""+id);
        }
    }

    public WareHouse deleteProduct( int wareHouseId ,Product product){
        var optionalWareHouse = wareHouseRepository.findById(wareHouseId);
        if (optionalWareHouse.isPresent()){
            var isContains = optionalWareHouse.get().getProducts().contains(product);
             if (isContains){
                 optionalWareHouse.get().remove(product);
                 return   wareHouseRepository.save(optionalWareHouse.get());
             }
             throw  new EntityNotFoundException(product.getId()+" : not found ");
        }
        throw new EntityNotFoundException(""+wareHouseId);
    }
}
