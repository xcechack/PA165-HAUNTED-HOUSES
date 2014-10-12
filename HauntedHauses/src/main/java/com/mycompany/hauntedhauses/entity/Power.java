/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Michal Zbranek
 */
@Entity
public class Power {
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    private String name; 
    private String description;

    @ManyToMany(mappedBy="ghost")
    private Ghost ghost;
    
    public Power(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
   
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
   
    public void setDescription(String description){
        this.description = description;
    }
    
}
