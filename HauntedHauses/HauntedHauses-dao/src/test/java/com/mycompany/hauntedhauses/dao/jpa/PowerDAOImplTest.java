/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.Power;
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
    private static PowerDAOImpl powerManager;
    
    private static Power power1;
    private static Power power2;
  
    
     
    public PowerDAOImplTest(){
        powerManager = new PowerDAOImpl(emf);
        clearPowersFromDatabase(); 
    }
    
    @BeforeClass
    public static void setup() {
        try {
            emf = Persistence.createEntityManagerFactory("GhostDB");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Could not initialize Persistence.");
        }
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
              
        
        
//        ghost1 = new Ghost();
//        
//        ghost1.setName("MyGhost");
//        long time = System.currentTimeMillis();
//        Timestamp startTime = new Timestamp(time);
//        Timestamp endTime = new Timestamp(time+3600000);
//        ghost1.setStartTime(startTime);
//        ghost1.setEndTime(endTime);
//        ghost1.setInfo("SomeInfoAboutMyGhost");
//        
//        house = new House();
//        house.setName("MyHouse");
//        Address address = new Address();
//        address.setStreet("MyAdress");
//        address.setHouseNumber(15);
//        address.setCity("MyTown");
//        address.setPostalCode(12345);
//        house.setAddress(address);
//        Date date = new Date(time);
//        house.setHauntedFrom(date);
//        house.setHistory("Was haunted before");
//        em.persist(house);
//        
//        ghost1.setHouse(house);
//        
//        power = new Power();
//        power.setName("Fire");
//        power.setDescription("Mortal");
//        em.persist(power);
//        
//        List powers = new ArrayList<Power>();
//        powers.add(power);
//        ghost1.setPowers(powers);
//        
//        em.persist(ghost1);
//        try {
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail("Could not commit Persistence.");
//        }
//	em.close();
    }
    
    @AfterClass
    public static void tearDown() {
//        PowerDAOImpl powerManager = new PowerDAOImpl(emf);
//        em = emf.createEntityManager();
//        House toBeRemoved = em.merge(house);
//        em.remove(toBeRemoved);
//        Power toBeRemovedPower = em.merge(power);
//        em.remove(toBeRemovedPower);
//        powerManager.deletePower(power);
    }

    @Test
    public void testAddPower() {
        power1 = new Power();  
        power1.setName("Fire");
        power1.setDescription("xxx");
        
        List<Power> powers = powerManager.getAllPowers();
        Assert.assertEquals(0, powers.size());        
        
        powerManager.addPower(power1);
        powers = powerManager.getAllPowers();
        Assert.assertEquals(1, powers.size());   
        
        powerManager.deletePower(power1);
        
        }
    
    @Test
    public void testUpdatePower() {
       power1 = new Power();  
       power1.setName("Fire");
       power1.setDescription("xxx"); 
      
       powerManager.addPower(power1);
       power1.setName("FireFire");
       powerManager.updatePower(power1);
       
       String newNameTest = powerManager.getPowerByID(power1.getId()).getName();
       Assert.assertEquals(newNameTest, "FireFire");
       
       powerManager.deletePower(power1);            
    }
    
    @Test
    public void testDeletePower() {
        power1 = new Power();  
        power1.setName("Fire");
        power1.setDescription("xxx");
        
        powerManager.addPower(power1);
        Assert.assertEquals(powerManager.getAllPowers().size(), 1);
        
        powerManager.deletePower(power1);
        Assert.assertEquals(powerManager.getAllPowers().size(), 0);
        
    }
    
    @Test
    public void testGetAllPowers() {
        power1 = new Power();
        power1.setName("Fire");
        power1.setDescription("xxx");
        powerManager.addPower(power1);
        Assert.assertEquals(powerManager.getAllPowers().size(), 1);
        
        power2 = new Power();
        power2.setName("Storm");
        power2.setDescription("xxx");
        powerManager.addPower(power2);
        Assert.assertEquals(powerManager.getAllPowers().size(), 2);
        
        clearPowersFromDatabase();
    }
    
    @Test
    public void testGetPowerById() {
        power1.setName("Fire");
        power1.setDescription("xxx");
        powerManager.addPower(power1);
        
        long id = power1.getId();
        Power power3 = powerManager.getPowerByID(id);
        Assert.assertEquals(power1, power3);
        
        powerManager.deletePower(power1);
    }
    
   
    public void clearPowersFromDatabase(){
        
        List<Power> powers = powerManager.getAllPowers();
        for (int i = 0; i<powers.size();i++){
            //System.out.println("Power to delete: "+powers.get(i).getId()+"\n");
            powerManager.deletePower(powers.get(i));
        }
    }
    
}
