package com.mycompany.hauntedhauses.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Markéta Kružliaková
 */

@Entity
public class Resident {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id = 0;
    
    private String firstName;
    
    private String lastName;
    
//  private House house;
    
    private int age;

    
    public Resident(){
    }
    
    public Resident(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    
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
    
    
}