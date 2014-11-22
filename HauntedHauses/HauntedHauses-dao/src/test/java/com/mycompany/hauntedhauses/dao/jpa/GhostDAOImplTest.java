/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.field.Address;
import java.util.ArrayList;
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
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 * @author Gabriela Podolnikova
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application" +
        "Context.xml")*/
public class GhostDAOImplTest {
    
    //@PersistenceUnit
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Ghost ghost1;
    private static House house;
    private static Power power;
    
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
        //Timestamp startTime = new Timestamp(timeL);
        //Timestamp endTime = new Timestamp(timeL+3600000);
        
        Date startTime = new Date(timeL);
        Date endTime = new Date(timeL+3600000);
        ghost1.setScaryTimeStart(startTime);
        ghost1.setScaryTimeEnd(endTime);
        ghost1.setInfo("Old man is haunting because he is lonely.");
        
        house = new House();
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
        
        power = new Power();
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
    
    @AfterClass
    public static void tearDown() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        House toBeRemoved = em.merge(house);
        em.remove(toBeRemoved);
        Power toBeRemovedPower = em.merge(power);
        em.remove(toBeRemovedPower);
        ghostManager.deleteGhost(ghost1);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testAddGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghostManager.deleteGhost(ghost1);
        ghostManager.addGhost(ghost1);
        Ghost ghost2 = ghostManager.getGhostByID(ghost1.getId());
        Assert.assertTrue(ghost1.equals(ghost2));
    }
    
    @Test
    public void testUpdateGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghost1.setName("Old woman");
        ghostManager.updateGhost(ghost1);
        Ghost ghost2 = ghostManager.getGhostByID(ghost1.getId());
        Assert.assertTrue(ghost1.equals(ghost2));
        ghostManager.deleteGhost(ghost1);
    }
    
    @Test
    public void testDeleteGhost() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghostManager.deleteGhost(ghost1);
        Assert.assertNull(ghostManager.getGhostByID(ghost1.getId()));
        ghostManager.addGhost(ghost1);
    }
    
    @Test
    public void testGetAllGhosts() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
	List<Ghost> ghosts = ghostManager.getAllGhosts();
	Assert.assertEquals(1, ghosts.size());
    }
    
    @Test
    public void testGetGhostById() {
        GhostDAOImpl ghostManager = new GhostDAOImpl(emf);
        ghostManager.addGhost(ghost1);
        Ghost ghost2 = ghostManager.getGhostByID(ghost1.getId());
        Assert.assertTrue(ghost1.equals(ghost2));
        ghostManager.addGhost(ghost1);
    }

}
