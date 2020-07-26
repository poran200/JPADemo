package com.example.demo.util.impl;

import com.example.demo.model.BaseModel;
import com.example.demo.util.CrudUntilService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

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
    public <B extends BaseModel, R extends JpaRepository<B, Long>> Object update(B b, R r, long id) {
        var bOptional = r.findById(id);
        bOptional.ifPresent(value -> b.setId(value.getId()));
        bOptional.orElseThrow(EntityNotFoundException::new);
        return save(b, r);
    }

    @Override
    public <B extends BaseModel, R extends JpaRepository<B, Long>> Object findById(long id, R r, Class<B> modelClass) {
        var optional = r.findById(id);
        return optional.orElseThrow( EntityNotFoundException::new);
    }
}
