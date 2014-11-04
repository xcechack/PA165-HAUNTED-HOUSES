/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import com.mycompany.hauntedhauses.service.field.Address;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.annotation.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity House is haunted by multiple ghost and can have multiple Residents.
 * @author Gabrila Podolnikova
 */
//@NamedQuery(name="getAllHouses",query="SELECT h FROM House h")
@Entity
public class House {
    
    @Id
    @GeneratedValue//(strategy=GenerationType.AUTO)
    private long id = 0;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    @Embedded
    private Address address;
    
    @Temporal(TemporalType.DATE)
    private Date hauntedFrom;
    
    @Column(nullable=false)
    private String history;
    
    @OneToMany(mappedBy="house")
    private Set<Ghost> ghosts = new HashSet<Ghost>();
    
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
    public Set<Ghost> getGhosts() {
        return ghosts;
    }

    /**
     * @param ghosts the ghosts to set
     */
    public void setGhosts(Set<Ghost> ghosts) {
        this.ghosts = ghosts;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (getId() ^ (getId() >>> 32));
        return result;
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
        House other = (House) obj;
        if (getId() != other.getId() || !name.equals(other.name) || !history.equals(other.history) || !address.equals(other.address) || !hauntedFrom.equals(other.hauntedFrom)) {
            return false;
        }
        return true;
    }
}
