package cz.muni.fi.pa165.hauntedhouses.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 *
 * @author Markéta Kružliaková
 */
public class GhostDTO implements Serializable {
    
    private Long id;

    private String name;
    
    private Timestamp scaryTimeStart;
    
    private Timestamp scaryTimeEnd;
    
    private String info;

    private Set<HouseDTO> houses;

    private Set<PowerDTO> powers;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<HouseDTO> getHouses() {
        return houses;
    }

    public void setHouses(Set<HouseDTO> houses) {
        this.houses = houses;
    }

    public void addHouseToGhost(HouseDTO house) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPowerToGhost(PowerDTO power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeHouseFromGhost(HouseDTO house) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removePowerFromGhost(PowerDTO power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
