package cz.muni.fi.pa165.hauntedhouses.service.dto;

import java.io.Serializable;


/**
 *
 * @author Markéta Kružliaková
 */
public class ResidentDTO implements Serializable {
    
    private Long id;
    
    private String firstName;
    
    private String lastName;

    private HouseDTO house;
    
    private Integer age;
    
    
    public Long getId(){
        return id;
    }
   
    public void setId(Long id){
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
