package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.entity.field.Address;
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


/**
 *
 * @author Markéta Kružliaková
 */
public class HouseDAOImplTest {
    
    //@PersistenceUnit
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Ghost ghost;
    private static House house;
    private static Resident resident;
    
    
    @BeforeClass
    public static void setup() {
        try {
            emf = Persistence.createEntityManagerFactory("TestDB");
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
        
        em.persist(house);
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
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        em = emf.createEntityManager();
        Resident toBeRemoved = em.merge(resident);
        em.remove(toBeRemoved);
        Ghost toBeRemovedGhost = em.merge(ghost);
        em.remove(toBeRemovedGhost);
        houseManager.deleteHouse(house);
    }

    @Test
    public void testAddHouse() {
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        House house2 = houseManager.getHouseById(house.getId());
        System.out.println("House 1: " + house.toString());
        System.out.println("House 2: " + house2.toString());
        Assert.assertTrue(house.equals(house2));
    }
    
    @Test
    public void testUpdateHouse() {
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        house.setName("Cool House");
        houseManager.updateHouse(house);
        House house2 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house2));
    }
    
    @Test
    public void testDeleteHouse() {
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        houseManager.deleteHouse(house);
        Assert.assertNull(houseManager.getHouseById(house.getId()));
        houseManager.addHouse(house);
    }
    
    @Test
    public void testGetAllHouses() {
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        List<House> houses = houseManager.getAllHouses();
	Assert.assertEquals(1, houses.size());
    }
    
    @Test
    public void testGetHouseById() {
        HouseDAOImpl houseManager = new HouseDAOImpl(emf);
        House house2 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house2));
    }

}
