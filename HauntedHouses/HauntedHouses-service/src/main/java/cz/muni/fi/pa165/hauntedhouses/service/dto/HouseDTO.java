package cz.muni.fi.pa165.hauntedhouses.service.dto;

import cz.muni.fi.pa165.hauntedhouses.service.field.Address;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Markéta Kružliaková
 */
public class HouseDTO implements Serializable {
    
    private Long id;
    
    private String name;
    
    private Address address;
    
    private Date hauntedFrom;
    
    private String history;
    
    private Set<GhostDTO> ghosts = new HashSet<GhostDTO>();
    
    private Set<ResidentDTO> residents = new HashSet<ResidentDTO>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getHauntedFrom() {
        return hauntedFrom;
    }

    public void setHauntedFrom(Date hauntedFrom) {
        this.hauntedFrom = hauntedFrom;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Set<ResidentDTO> getResidents() {
        return residents;
    }

    public void setResidents(Set<ResidentDTO> residents) {
        this.residents = residents;
    }

    public Set<GhostDTO> getGhosts() {
        return ghosts;
    }

    public void setGhosts(Set<GhostDTO> ghosts) {
        this.ghosts = ghosts;
    }  
}
