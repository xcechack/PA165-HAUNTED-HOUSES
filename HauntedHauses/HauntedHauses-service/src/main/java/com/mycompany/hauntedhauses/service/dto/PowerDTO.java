/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Markéta Kružliaková
 */
public class PowerDTO implements Serializable {
    
    private long id;
    
    private String name; 
    
    private String description;

    private Set<GhostDTO> ghosts = new HashSet<GhostDTO>();
    
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
    public Set<GhostDTO> getGhosts() {
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
    public void setGhosts(Set<GhostDTO> ghosts) {
        this.ghosts = ghosts;
    }
    
}
