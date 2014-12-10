package cz.muni.fi.pa165.hauntedhouses.service.dto;

import cz.muni.fi.pa165.hauntedhouses.service.field.Address;
import java.io.Serializable;
import java.util.Date;
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
    
    private Set<GhostDTO> ghosts;
    
    private Set<ResidentDTO> residents;


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

    public void addGhostToHouse(GhostDTO ghost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeGhostFromHouse(GhostDTO ghost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addResidentToHouse(ResidentDTO resident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeResidentFromHouse(ResidentDTO resident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
