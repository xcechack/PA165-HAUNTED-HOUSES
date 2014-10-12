/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.entity.field.Address;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Gabriela Podolnikova
 */
public class GhostDAOImplTest {
    
    //@PersistenceUnit
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Ghost ghost1;
    
    
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
        
        ghost1 = new Ghost();
        
        ghost1.setName("Old man");
        long timeL = System.currentTimeMillis();
        Timestamp startTime = new Timestamp(timeL);
        Timestamp endTime = new Timestamp(timeL+3600000);
        ghost1.setStartTime(startTime);
        ghost1.setEndTime(endTime);
        ghost1.setInfo("Old man is haunting because he is lonely.");
        
        House house = new House();
        house.setName("House name");
        Address address = new Address();
        address.setStreet("Ruzova");
        address.setHouseNumber(15);
        address.setCity("Brno");
        address.setPostalCode(63000);
        house.setAddress(address);
        Date date = new Date(timeL);
        house.setHauntedFrom(date);
        house.setHistory("Was haunted before");
        em.persist(house);
        
        ghost1.setHouse(house);
        
        Power power = new Power();
        power.setName("Fire");
        power.setDescription("Mortal");
        em.persist(power);
        
        List powers = new ArrayList<Power>();
        powers.add(power);
        ghost1.setPowers(powers);
        
        em.persist(ghost1);
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Could not commit Persistence.");
        }
	em.close();
    }

    @Test
    public void testAddGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        Ghost ghost2 = ghostManager.getGhostByID(ghost1.getId());
        System.out.println("Ghost 1: " + ghost1.toString());
        System.out.println("Ghost 2: " + ghost2.toString());
        Assert.assertTrue(ghost1.equals(ghost2));
    }
    
    @Test
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
        
    }

}
