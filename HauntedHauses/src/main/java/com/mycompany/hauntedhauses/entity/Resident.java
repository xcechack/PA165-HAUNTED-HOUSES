package com.mycompany.hauntedhauses.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Resident can live in one house.
 * @author Markéta Kružliaková
 */

@Entity
public class Resident {
    
    @Id
    @GeneratedValue//(strategy=GenerationType.AUTO)
    private long id = 0;
    
    private String firstName;
    
    private String lastName;
    

    @ManyToOne(fetch = FetchType.LAZY)
    private House house;
    
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
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = (int)(hash * 17 + id);
        hash = hash * 31 + firstName.hashCode();
        hash = hash * 13 + lastName.hashCode();
        return hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Resident guest = (Resident) obj;
        return id == guest.id
                && (firstName == guest.firstName
                     || (firstName != null && firstName.equals(guest.getFirstName())))
                && (lastName == guest.lastName
                     || (lastName != null && lastName .equals(guest.getLastName())))
                && (age == guest.age);
    }

}