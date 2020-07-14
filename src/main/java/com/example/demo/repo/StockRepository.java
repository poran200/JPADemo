package com.example.demo.repo;

import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Arrays;

public interface StockRepository extends JpaRepository<Stock,Long> {

}
