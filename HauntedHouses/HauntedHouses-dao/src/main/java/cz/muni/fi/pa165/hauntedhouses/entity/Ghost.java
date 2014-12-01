package cz.muni.fi.pa165.hauntedhouses.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Jana Cechackova
 */
@Entity
public class Ghost {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;
    
    private Timestamp scaryTimeStart;
    
    private Timestamp scaryTimeEnd;
    
    private String info;

    @ManyToOne
    private House house;

    @ManyToMany(mappedBy = "ghosts", fetch = FetchType.LAZY)
    private List<Power> powers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        this.id = newId;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }   

    @Override
    public int hashCode() {
        int hash = 1;
        hash = (int)(hash * 17 + id);
        hash = hash * 31 + name.hashCode();
        hash = hash * 13 + info.hashCode();
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ghost other = (Ghost) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.scaryTimeStart, other.scaryTimeStart)) {
            return false;
        }
        if (!Objects.equals(this.scaryTimeEnd, other.scaryTimeEnd)) {
            return false;
        }
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Ghost [id=" + id + ", name=" + name + ", scaryTimeStart=" + scaryTimeStart + ", scaryTimeEnd=" + scaryTimeEnd + ",info" + info + "]";
    }
}