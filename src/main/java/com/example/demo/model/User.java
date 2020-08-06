package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  extends  BaseModel{
    private String userName;
    private  String password;
    private  String email;
    private  String imageUrl;
    @ManyToMany(cascade = CascadeType.ALL,fetch =  FetchType.EAGER)
    private Set<Role> roles ;

    public void addRole(Role role){
        if (roles == null){
            this.roles = new HashSet<>();
        }
       this.roles.add(role);
    }
}
