package cz.muni.fi.pa165.hauntedhouses.entity;

import cz.muni.fi.pa165.hauntedhouses.field.Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity House is haunted by multiple ghost and can have multiple Residents.
 * @author Gabriela Podolnikova
 */

@Entity
public class House {
    
    @Id
    @GeneratedValue
    private Long id;
    
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
    private List<Ghost> ghosts = new ArrayList<>();
    
    @OneToMany(mappedBy="house")
    private List<Resident> residents = new ArrayList<>();


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

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final House other = (House) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.hauntedFrom, other.hauntedFrom)) {
            return false;
        }
        if (!Objects.equals(this.history, other.history)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "House{" + "id=" + id + ", name=" + name + ", address=" + address + ", hauntedFrom=" + hauntedFrom + ", history=" + history + '}';
    }
}
