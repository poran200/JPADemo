package com.example.demo.util.impl;

import com.example.demo.model.BaseModel;
import com.example.demo.util.CrudUntilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class CrudUtilServiceImpl implements CrudUntilService {
    Logger logger = LoggerFactory.getLogger(CrudUtilServiceImpl.class.getName());
    @Override
    public <B extends BaseModel, R extends JpaRepository<B,Long>> BaseModel save(B b, R r) {
        var o = r.findById(b.getId());
        B object = null;
        try{
           if (o.isEmpty()){
                object = r.save(b);
           }else {
               throw  new EntityExistsException("entity already exist");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        assert object != null;
        return getCreateResponse(object);

    }


    private <B extends BaseModel> B getCreateResponse(B b) {
        logger.info("created entity ");
        logger.info("{id}",b.getId());
        return b;
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
