package com.example.demo.model;

import com.example.demo.model.warehouse.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Product {
    @Id
    private long id;
    private String productName;
    @ManyToMany(mappedBy = "products")
    private Set<WareHouse> wareHouses = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private List<Stock> stockList;

    public void addStock(Stock stock) {
        if (stockList == null) {
            stockList = new ArrayList<>();
        }
        stockList.add(stock);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
