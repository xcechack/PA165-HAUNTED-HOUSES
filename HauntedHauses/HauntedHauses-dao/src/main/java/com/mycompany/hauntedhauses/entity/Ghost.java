/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    @Temporal(TemporalType.DATE)
    private Date scaryTimeStart;
    @Temporal(TemporalType.DATE)
    private Date scaryTimeEnd;
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    private House house;

    @ManyToMany(mappedBy = "ghosts", fetch = FetchType.LAZY)
    private List<Power> powers = new ArrayList<Power>();

    public long getId() {
        return id;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartTime(Date time) {
        this.scaryTimeStart = time;
    }

    public Date getStartTime() {
        return scaryTimeStart;
    }

    public void setEndTime(Date time) {
        this.scaryTimeEnd = time;
    }

    public Date getEndTime() {
        return scaryTimeEnd;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
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
    public int hashCode() {
        int hash = 1;
        hash = (int)(hash * 17 + id);
        hash = hash * 31 + name.hashCode();
        hash = hash * 13 + info.hashCode();
        return hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Ghost other = (Ghost) obj;
        if (getId() != other.getId() || !name.equals(other.name) || !scaryTimeStart.equals(other.scaryTimeStart) || !scaryTimeEnd.equals(other.scaryTimeEnd) || !info.equals(other.info)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Ghost [id=" + id + ", name=" + name + ", scaryTimeStart=" + scaryTimeStart + ", scaryTimeEnd=" + scaryTimeEnd + ",info" + info + "]";
    }
}
