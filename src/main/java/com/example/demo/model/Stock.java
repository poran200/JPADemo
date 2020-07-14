package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock {
    @Id
    private long id;
    private long quantity;
    @OneToOne
    @JsonIgnoreProperties(value = "productList")
    private  Shop shop;

    @ManyToOne
    @JsonIgnore
    private  Product product;

    public Stock(long id, int quantity, Shop shop) {
        this.id = id;
        this.quantity = quantity;
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quntity=" + quantity +
                '}';
    }
}
