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
import java.sql.Timestamp;
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

/**
 *
 * @author Jana Cechackova
 */
public class PowerDAOImplTest {
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
        
        ghost1.setName("MyGhost");
        long time = System.currentTimeMillis();
        Timestamp startTime = new Timestamp(time);
        Timestamp endTime = new Timestamp(time+3600000);
        ghost1.setStartTime(startTime);
        ghost1.setEndTime(endTime);
        ghost1.setInfo("SomeInfoAboutMyGhost");
        
        house = new House();
        house.setName("MyHouse");
        Address address = new Address();
        address.setStreet("MyAdress");
        address.setHouseNumber(15);
        address.setCity("MyTown");
        address.setPostalCode(12345);
        house.setAddress(address);
        Date date = new Date(time);
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
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
        em = emf.createEntityManager();
        House toBeRemoved = em.merge(house);
        em.remove(toBeRemoved);
        Power toBeRemovedPower = em.merge(power);
        em.remove(toBeRemovedPower);
        powerManager.deletePower(power);
    }

    @Test
    public void testAddPower() {
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
        Power power2 = powerManager.getPowerByID(ghost1.getId());
        System.out.println("Power 1: " + power.toString());
        System.out.println("Power 2: " + power2.toString());
        Assert.assertTrue(power.equals(power2));
    }
    
    @Test
    public void testUpdatePower() {
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
        power.setName("mySecondPower");
        powerManager.updatePower(power);
        Power power2 = powerManager.getPowerByID(power.getId());
        Assert.assertTrue(power.equals(power2));
    }
    
    @Test
    public void testDeletePower() {
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
        powerManager.deletePower(power);
        Assert.assertNull(powerManager.getPowerByID(power.getId()));
        powerManager.addPower(power);
    }
    
    @Test
    public void testGetAllPowers() {
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
	List<Power> powers = powerManager.getAllPowers();
	Assert.assertEquals(1, powers.size());
    }
    
    @Test
    public void testGetPowerById() {
        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
        Power power2 = powerManager.getPowerByID(power.getId());
        Assert.assertTrue(power.equals(power2));
    }
}
