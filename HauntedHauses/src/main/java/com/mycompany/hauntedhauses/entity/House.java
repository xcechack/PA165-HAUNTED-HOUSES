/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity House is haunted by multiple ghost and can have multiple Residents.
 * @author Gabrila Podolnikova
 */
@Entity
public class House {
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    private String name;
    private Address address;
    private Date hauntedFrom;
    private String history;
    
    //@OneToMany(mappedBy="house")
    //private Set<Ghost> ghosts = new HashSet<Ghost>();
    
    @OneToMany(mappedBy="house")
    private Set<Resident> residents = new HashSet<Resident>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the hauntedFrom
     */
    public Date getHauntedFrom() {
        return hauntedFrom;
    }

    /**
     * @param hauntedFrom the hauntedFrom to set
     */
    public void setHauntedFrom(Date hauntedFrom) {
        this.hauntedFrom = hauntedFrom;
    }

    /**
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * @return the residents
     */
    public Set<Resident> getResidents() {
        return residents;
    }

    /**
     * @param residents the residents to set
     */
    public void setResidents(Set<Resident> residents) {
        this.residents = residents;
    }

    /**
     * @return the ghosts
     */
    /*public Set<Ghost> getGhosts() {
        return ghosts;
    }

    /**
     * @param ghosts the ghosts to set
     */
    /*public void setGhosts(Set<Ghost> ghosts) {
        this.ghosts = ghosts;
    }*/
}
