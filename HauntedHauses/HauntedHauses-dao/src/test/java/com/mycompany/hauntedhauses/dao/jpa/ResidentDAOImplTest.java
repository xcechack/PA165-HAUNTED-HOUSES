/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.field.Address;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Michal Zbranek
 */
public class ResidentDAOImplTest {
    
    private static EntityManagerFactory emf;

    private static EntityManager em;
    private static Resident resident;
    private static House house;
    
    @BeforeClass
    public static void setup() {
        try {
            emf = Persistence.createEntityManagerFactory("GhostDB");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        resident = new Resident();
        
        resident.setFirstName("Michal");
        resident.setLastName("Zbranek");
        resident.setAge(22);
        long timeL = System.currentTimeMillis();
        
        house = new House();
        house.setName("House name");
        Address address = new Address();
        address.setStreet("Vranovska");
        address.setHouseNumber(84);
        address.setCity("Brno");
        address.setPostalCode(61400);
        house.setAddress(address);
        Date date = new Date(timeL);
        house.setHauntedFrom(date);
        house.setHistory("Old house with horrible history of countless murders");
        em.persist(house);
        
        resident.setHouse(house);
        
        em.persist(resident);
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Could not commit Persistence.");
        }
	em.close();
    }

    @AfterClass
    public static void tearDown() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        House toBeRemoved = em.merge(house);
        em.remove(toBeRemoved);
        residentManager.deleteResident(resident);
        em.getTransaction().commit();
    }
    
    @Test
    public void testAddResident() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
        Resident resident1 = residentManager.getResidentByID(resident.getId());
        System.out.println("Resident 1: " + resident.toString());
        System.out.println("Resident 2: " + resident1.toString());
        Assert.assertTrue(resident.equals(resident1));
    }
    
    @Test
    public void testUpdateResident() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
        resident.setFirstName("David");
        residentManager.updateResident(resident);
        Resident resident1 = residentManager.getResidentByID(resident.getId());
        Assert.assertTrue(resident.equals(resident1));
    }
    
    @Test
    public void testDeleteResident() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf); 
        residentManager.deleteResident(resident);
        Assert.assertNull(residentManager.getResidentByID(resident.getId()));
        residentManager.addResident(resident);
    }
    
    @Test
    public void testGetAllResidents() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
	List<Resident> residents = residentManager.getAllResidents();
	Assert.assertEquals(1, residents.size());
    }
    
    @Test
    public void testGetResidentById() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
        Resident resident1 = residentManager.getResidentByID(resident.getId());
        Assert.assertTrue(resident.equals(resident1));
    }

}
