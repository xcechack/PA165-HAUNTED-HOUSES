/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Markéta Kružliaková
 */

public class Resident {
    
    @Id
    @GeneratedValue
    private long id = -1;
    
    private String firstName;
    
    private String lastName;
    
//  private House house;
    
    private int age;

    
    
    public String getFirstName(){
        return firstName;
    }
   
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return firstName;
    }
   
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public int age(){
        return age;
    }
   
    public void age(int age){
        this.age = age;
    }
    
    
}
