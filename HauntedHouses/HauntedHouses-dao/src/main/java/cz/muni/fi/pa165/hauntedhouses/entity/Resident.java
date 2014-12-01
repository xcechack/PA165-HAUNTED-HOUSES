package cz.muni.fi.pa165.hauntedhouses.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Resident can live in one house.
 * @author Markéta Kružliaková
 */

@Entity
public class Resident {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable=false)
    private String firstName;
    
    @Column(nullable=false)
    private String lastName;

    @ManyToOne
    private House house;
    
    @Column(nullable=true)
    private int age;
    
    
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
    
    public House getHouse(){
        return house;
    }
   
    public void setHouse(House house){
        this.house = house;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resident other = (Resident) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Resident{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }
}