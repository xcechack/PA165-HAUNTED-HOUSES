/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hauntedhauses.entity;

import java.sql.Time;
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
private Time scaryTimeStart;
private Time scaryTimeEnd;
private String info;

@ManyToOne(fetch = FetchType.LAZY)
private House house;

@ManyToMany(mappedBy="ghosts", fetch = FetchType.LAZY)
private List<Power> powers = new ArrayList<Power>();

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

public void setStartTime(Time time){
    this.scaryTimeStart = time;
}

public Time getStartTime(){
    return scaryTimeStart;
}

public void setEndTime(Time time){
    this.scaryTimeEnd = time;
}

public Time getEndTime(){
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


}
