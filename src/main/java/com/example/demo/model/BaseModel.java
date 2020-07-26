package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@MappedSuperclass
public  abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private  Date createdAt;
    private  String createdBy;
    @PrePersist
    public void  createdDate(){
        this.createdAt = new Date();
    }

}
