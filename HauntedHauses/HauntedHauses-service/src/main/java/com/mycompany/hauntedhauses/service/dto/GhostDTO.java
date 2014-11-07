/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public class GhostDTO implements Serializable {
    
    private long id;

    private String name;
    private Timestamp scaryTimeStart;
    private Timestamp scaryTimeEnd;
    private String info;

    private HouseDTO house;

    private List<PowerDTO> powers = new ArrayList<PowerDTO>();

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

    public void setStartTime(Timestamp time) {
        this.scaryTimeStart = time;
    }

    public Timestamp getStartTime() {
        return scaryTimeStart;
    }

    public void setEndTime(Timestamp time) {
        this.scaryTimeEnd = time;
    }

    public Timestamp getEndTime() {
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
    public HouseDTO getHouse() {
        return house;
    }

    /**
     * @param house the house to set
     */
    public void setHouse(HouseDTO house) {
        this.house = house;
    }

    /**
     * @return the powers
     */
    public List<PowerDTO> getPowers() {
        return powers;
    }

    /**
     * @param powers the powers to set
     */
    public void setPowers(List<PowerDTO> powers) {
        this.powers = powers;
    }   
    
}
