package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.dao.jpa.HouseManagerImpl;
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
        Resident resident = new Resident("Jan", "Novák", 30);
        ResidentDAOImpl residentDAO = new ResidentDAOImpl(entityManagerFactoryGhost);
        residentDAO.addResident(resident);
        
        //testing houseDB
        EntityManagerFactory emfHouse = Persistence.createEntityManagerFactory("HouseDB");
        Address address = new Address("Otiskova", 7, "Brno", 62800);
        Date date = new Date();
        House house = new House("house", address, date, "history");
        HouseManagerImpl houseManagerImpl = new HouseManagerImpl(emfHouse);
        houseManagerImpl.addHouse(house);
    }
}
