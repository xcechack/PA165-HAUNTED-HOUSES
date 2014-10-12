/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.entity.field.Address;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
    
    @BeforeClass
    public static void setup() {
        try {
            emf = Persistence.createEntityManagerFactory("ResidentDB");
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
        
        House house = new House();
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

    @Test
    public void testAddResident() {
        ResidentDAOImpl residentManager = new ResidentDAOImpl(emf);
        Resident resident1 = residentManager.getResidentByID(resident.getId());
        System.out.println("Resident 1: " + resident.toString());
        System.out.println("Resident 2: " + resident1.toString());
        Assert.assertTrue(resident.equals(resident1));
    }
    
    /*@Test
    public void testUpdateGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghost1.setName("Old women");
        ghostManager.updateGhost(ghost1);
        //Assert.assertEquals(ghost1, ghost2);
    }
    
    @Test
    public void testDeleteGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghostManager.deleteGhost(ghost1);
        ghostManager.getGhostByID(ghost1.getId());
    }
    
    @Test
    public void testGetAllGhosts() {
        EntityManager em = emf.createEntityManager();
	List<Ghost> ghosts = em.createQuery("FROM Ghost",Ghost.class).getResultList();
	Assert.assertEquals(ghosts.size(), 1);
	em.close();
    }
    
    @Test
    public void testGetGhostById() {
        
    }*/

}
