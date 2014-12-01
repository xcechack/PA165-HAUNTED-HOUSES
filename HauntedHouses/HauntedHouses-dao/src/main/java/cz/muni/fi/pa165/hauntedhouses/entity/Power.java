package cz.muni.fi.pa165.hauntedhouses.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private Long id;
    
    @Column(nullable=false)
    private String name; 
    
    @Column
    private String description;

    @ManyToMany
    private List<Ghost> ghosts = new ArrayList<>();
    
    
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

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGhosts(List<Ghost> ghosts) {
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Power other = (Power) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Power{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
}
