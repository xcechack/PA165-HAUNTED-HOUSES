/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hauntedhauses.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Jana Cechackova
 */
@Entity
public class Ghost {
    
@Id
@GeneratedValue
private long id = 0;

private String name;
private Timestamp scaryTimeStart;
private Timestamp scaryTimeEnd;
private String info;

@ManyToOne(fetch = FetchType.LAZY)
private House house;

@ManyToMany(mappedBy="ghosts", fetch = FetchType.LAZY)
private List<Power> powers = new ArrayList<Power>();

public Ghost(String name, Timestamp scaryTimeStart, Timestamp scaryTimeEnd, String info, House house){
    
    this.name = name;
    this.scaryTimeStart = scaryTimeStart;
    this.scaryTimeEnd = scaryTimeEnd;
    this.info = info;
    this.house = house;

}

public long getId(){
    return id;
    }

public void setId(long newId){
    this.id = newId;
}

public void setName(String name){
    this.name = name;
}

public String getName(){
    return name;
}

public void setStartTime(Timestamp time){
    this.scaryTimeStart = time;
}

public Timestamp getStartTime(){
    return scaryTimeStart;
}

public void setEndTime(Timestamp time){
    this.scaryTimeEnd = time;
}

public Timestamp getEndTime(){
    return scaryTimeEnd;
}

public String getInfo(){
    return info;
}

public void setInfo(String info){
    this.info = info;
}

    /**
     * @return the house
     */
    public House getHouse() {
        return house;
    }

    /**
     * @param house the house to set
     */
    public void setHouse(House house) {
        this.house = house;
    }

    /**
     * @return the powers
     */
    public List<Power> getPowers() {
        return powers;
    }

    /**
     * @param powers the powers to set
     */
    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
    
@Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()) return false;
        
        Ghost ghost = (Ghost) obj;
        return id == ghost.getId();
    
    }
    
@Override
    public int hashCode(){
        int hash = 1;
        hash = (int)(hash*17 + id);
        hash = hash*31 + name.hashCode();
        
        return hash;
    
    }
    
    


}
