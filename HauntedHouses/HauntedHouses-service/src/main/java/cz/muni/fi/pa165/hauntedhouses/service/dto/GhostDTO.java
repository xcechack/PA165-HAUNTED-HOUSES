package cz.muni.fi.pa165.hauntedhouses.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    private HouseDTO house;

    private List<PowerDTO> powers = new ArrayList<PowerDTO>();
    

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

    public HouseDTO getHouse() {
        return house;
    }

    public void setHouse(HouseDTO house) {
        this.house = house;
    }

    public List<PowerDTO> getPowers() {
        return powers;
    }

    public void setPowers(List<PowerDTO> powers) {
        this.powers = powers;
    }   
    
}
