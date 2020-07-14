package com.example.demo.model.warehouse;

import com.example.demo.model.Product;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WareHouse {
    @Id
    private  Integer wareHouseId;
    private  String  name;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "warehouse_product",
            joinColumns = @JoinColumn(name = "wareHouse_Id"),
            inverseJoinColumns = @JoinColumn(name = "porduct_Id")
    )
    private Set<Product> products;
    public void addProduct(Product product){
        if (products == null){
            products = new HashSet<>();
        }
        products.add(product);
//        product.getWareHouses().add(this);
    }
    public void remove(Product product){
        this.products.remove(product);
//        product.getWareHouses().remove(this);

    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "wareHouseId=" + wareHouseId +
                ", name='" + name + '\'' +
                '}';
    }
}
