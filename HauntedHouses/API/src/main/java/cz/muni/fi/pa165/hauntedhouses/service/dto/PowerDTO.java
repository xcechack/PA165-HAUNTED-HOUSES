package cz.muni.fi.pa165.hauntedhouses.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Markéta Kružliaková
 */
public class PowerDTO implements Serializable {
    
    private Long id;
    
    private String name; 
    
    private String description;

    private Set<GhostDTO> ghosts = new HashSet<GhostDTO>();
    

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
    
    public Set<GhostDTO> getGhosts() {
        return ghosts;
    }
    
    public void setGhosts(Set<GhostDTO> ghosts) {
        this.ghosts = ghosts;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
