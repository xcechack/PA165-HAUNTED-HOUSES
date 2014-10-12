/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hauntedhauses.entity;

import java.sql.Time;
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

// "Kazde strasidlo muze strasit pouze v jednom dome." Muze byt v jednom dome vice strasidel??
@OneToOne(mappedBy="house")
private House house;

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


}
