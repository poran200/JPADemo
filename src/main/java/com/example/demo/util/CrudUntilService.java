package com.example.demo.util;

import com.example.demo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUntilService {
    <B extends BaseModel, R extends JpaRepository<B,Long>> Object  save(B b, R r);
    <B extends BaseModel, R extends JpaRepository<B,Long>> Object  update(B b, R r,long id);
    <B extends BaseModel, R extends JpaRepository<B,Long>> Object findById(long id, R r,Class<B>b);
}
