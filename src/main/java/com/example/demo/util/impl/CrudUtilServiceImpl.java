package com.example.demo.util.impl;

import com.example.demo.model.BaseModel;
import com.example.demo.util.CrudUntilService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class CrudUtilServiceImpl implements CrudUntilService {
    @Override
    public <B extends BaseModel, R extends JpaRepository<B,Long>> Object save(B b, R r) {
        var o = r.findById(b.getId());
        Object save = new Object();
        try{
           if (o.isEmpty()){
                save = r.save(b);
           }else {
               throw  new EntityExistsException("entity already exist");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return save;
    }

    @Override
    public <B extends BaseModel, R extends JpaRepository<B, Long>> Object update(B b, R r) {
        b.setId(b.getId());
        return save(b, r);
    }
}
