package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.field.Address;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 * @author Markéta Kružliaková
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application" +
        "Context.xml")
public class HouseDAOImplTest {
    
    //@PersistenceUnit
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Ghost ghost;
    private static House house;
    private static Resident resident;
    
    //@Autowired
    HouseDAOImpl houseManager = new HouseDAOImpl();
    
    
    @BeforeClass
    public static void setup() {
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        
        try {
            emf = Persistence.createEntityManagerFactory("GhostDB");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        ghost = new Ghost();
        
        ghost.setName("Old man");
        long timeL = System.currentTimeMillis();
        Timestamp startTime = new Timestamp(timeL);
        Timestamp endTime = new Timestamp(timeL+3600000);
        ghost.setStartTime(startTime);
        ghost.setEndTime(endTime);
        ghost.setInfo("Old man is haunting because he is lonely.");
        em.persist(ghost);
        
        resident = new Resident();
        resident.setFirstName("Dušan");
        resident.setLastName("Nový");
        resident.setAge(22);
        em.persist(resident);
        
        house = new House();
        house.setName("House name");
        Address address = new Address();
        address.setStreet("Ruzova");
        address.setHouseNumber(15);
        address.setPostalCode(63000);
        address.setCity("Brno");

        house.setAddress(address);
        Date date = new Date(timeL);
        house.setHauntedFrom(date);
        house.setHistory("Was haunted before");  
        
        Set<Ghost> ghosts = new HashSet<Ghost>();
        ghosts.add(ghost);
        house.setGhosts(ghosts);
        
        Set<Resident> residents = new HashSet<Resident>();
        residents.add(resident);
        house.setResidents(residents);
        
        //em.persist(house);
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
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Resident toBeRemoved = em.merge(resident);
        em.remove(toBeRemoved);
        System.out.println("Removed Resident");
        Ghost toBeRemovedGhost = em.merge(ghost);
        em.remove(toBeRemovedGhost);
        em.getTransaction().commit();
        System.out.println("Removed Ghost");
        em.close();
    }

    @Test
    public void testAddHouse() {
       // HouseDAOImpl houseManager = new HouseDAOImpl(emf);
       
        
        /*house = new House();
        house.setName("House name");
        Address address = new Address();
        address.setStreet("Ruzova");
        address.setHouseNumber(15);
        address.setPostalCode(63000);
        address.setCity("Brno");
        house.setAddress(address);
        long timeL = System.currentTimeMillis();
        Date date = new Date(timeL);
        house.setHauntedFrom(date);
        house.setHistory("Was haunted before");  */
        
        List<House> houses = houseManager.getAllHouses();
        Assert.assertEquals(0, houses.size());
        
        houseManager.addHouse(house);
        
        houses = houseManager.getAllHouses();
        Assert.assertEquals(1, houses.size());  
        
        houseManager.deleteHouse(house);
        
        //House house2 = houseManager.getHouseById(house.getId());
        //System.out.println("House 1: " + house.toString());
        //System.out.println("House 2: " + house2.toString());
        //Assert.assertTrue(house.equals(house2));
    }
    
    @Test
    public void testUpdateHouse() {
        //HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        house.setName("Cool House");
        houseManager.updateHouse(house);
        House house2 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house2));
        houseManager.deleteHouse(house);
    }
    
    @Test
    public void testDeleteHouse() {
        //HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        houseManager.deleteHouse(house);
        Assert.assertNull(houseManager.getHouseById(house.getId()));
        houseManager.addHouse(house);
    }
    
    @Test
    public void testGetAllHouses() {
        //HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        houseManager.addHouse(house);
        List<House> houses = houseManager.getAllHouses();
        Assert.assertEquals(1, houses.size());
        houseManager.deleteHouse(house);
        houses = houseManager.getAllHouses();
	Assert.assertEquals(0, houses.size());
    }
    
    @Test
    public void testGetHouseById() {
        //HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        houseManager.addHouse(house);
        House house2 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house2));
        houseManager.deleteHouse(house);
    }

}
