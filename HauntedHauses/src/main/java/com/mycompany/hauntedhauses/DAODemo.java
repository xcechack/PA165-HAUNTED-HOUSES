package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.dao.jpa.ResidentDAOImpl;
import com.mycompany.hauntedhauses.dao.jpa.HouseDAOImpl;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.entity.field.Address;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Markéta Kružliaková
 */
public class DAODemo {

    public static void main(String[] args) {
      
        //test funkčnosti metody addResident(Resident resident)
        EntityManagerFactory entityManagerFactoryGhost = Persistence.createEntityManagerFactory("GhostDB");
        Resident resident = new Resident();
        resident.setAge(50);
        resident.setFirstName("Pepa");
        resident.setLastName("Dvorak");
        ResidentDAOImpl residentDAO = new ResidentDAOImpl(entityManagerFactoryGhost);
        residentDAO.addResident(resident);
        
        //testing house
        EntityManagerFactory emfHouse = Persistence.createEntityManagerFactory("GhostDB");
        Address address = new Address("Ruzova", 7, "Brno", 63000);
        Date date = new Date();
        House house = new House();
        house.setAddress(address);
        house.setHistory("history");
        house.setName("name");
        house.setHauntedFrom(date);
        HouseDAOImpl houseManagerImpl = new HouseDAOImpl(emfHouse);
        houseManagerImpl.addHouse(house);
    }
}
