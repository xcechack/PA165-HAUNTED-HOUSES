/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Michal Zbranek
 */
@Entity
public class Power {
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    private String name; 
    private String description;

    @ManyToMany(mappedBy="powers")
    private Set<Ghost> ghosts = new HashSet<Ghost>();
    
    public String getName(){
        return name;
    }
   
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
   
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
    
}
