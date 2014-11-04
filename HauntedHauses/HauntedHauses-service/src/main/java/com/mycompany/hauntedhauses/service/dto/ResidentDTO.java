/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.dto;

import java.io.Serializable;


/**
 *
 * @author Markéta Kružliaková
 */
public class ResidentDTO implements Serializable {
    
    private long id;
    
    private String firstName;
    
    private String lastName;

    private HouseDTO house;
    
    private Integer age;
    
    
    public long getId(){
        return id;
    }
   
    public void setId(long id){
        this.id = id;
    }
    
    public String getFirstName(){
        return firstName;
    }
   
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
   
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public int getAge(){
        return age;
    }
   
    public void setAge(int age){
        this.age = age;
    }
    
    public HouseDTO getHouse(){
        return house;
    }
   
    public void setHouse(HouseDTO house){
        this.house = house;
    }
    
}
