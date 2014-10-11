package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.entity.Resident;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Markéta Kružliaková
 */
public class DAODemo {

    public static void main(String[] args) {
      
        //test funkčnosti metody addResident(Resident resident)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GhostDB");
        Resident resident = new Resident("Jan", "Novák", 30);
        ResidentDAOImpl residentDAO = new ResidentDAOImpl(entityManagerFactory);
        residentDAO.addResident(resident);
    }
}
