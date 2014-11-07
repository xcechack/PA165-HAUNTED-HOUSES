/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public class GhostDTO implements Serializable {
    
    private Long id;

    private String name;
    private Date scaryTimeStart;
    private Date scaryTimeEnd;
    private String info;

    private HouseDTO house;

    private List<PowerDTO> powers = new ArrayList<PowerDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        this.id = newId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    /**
     * @return the scaryTimeStart
     */
    public Date getScaryTimeStart() {
        return scaryTimeStart;
    }

    /**
     * @param scaryTimeStart the scaryTimeStart to set
     */
    public void setScaryTimeStart(Date scaryTimeStart) {
        this.scaryTimeStart = scaryTimeStart;
    }

    /**
     * @return the scaryTimeEnd
     */
    public Date getScaryTimeEnd() {
        return scaryTimeEnd;
    }

    /**
     * @param scaryTimeEnd the scaryTimeEnd to set
     */
    public void setScaryTimeEnd(Date scaryTimeEnd) {
        this.scaryTimeEnd = scaryTimeEnd;
    }
    
}
