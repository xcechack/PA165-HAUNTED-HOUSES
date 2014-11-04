/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity Power can be used by many ghosts and ghosts can have many powers
 * @author Michal Zbranek
 */
@Entity
public class Power {
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    @Column(nullable=false)
    private String name; 
    
    @Column(nullable=false)
    private String description;

    @ManyToMany//(mappedBy="powers")
    private Set<Ghost> ghosts = new HashSet<Ghost>();
    
    /**
     * 
     * @return the name
     */
    public String getName(){
        return name;
    }
   
    /**
     * 
     * @param name to set 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * 
     * @return the description 
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * 
     * @param description to set 
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * @return the ghost
     */
    public Set<Ghost> getGhosts() {
        return ghosts;
    }


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
     * @param ghosts the ghosts to set
     */
    public void setGhosts(Set<Ghost> ghosts) {
        this.ghosts = ghosts;
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = (int)(hash * 17 + id);
        hash = hash * 31 + name.hashCode();
        hash = hash * 13 + description.hashCode();
        return hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Power power = (Power) obj;
        return id == power.id
                && (name == power.name
                     || (name != null && name.equals(power.getName())))
                && (description == power.description
                     || (description != null && description .equals(power.getDescription())));
    }
}
