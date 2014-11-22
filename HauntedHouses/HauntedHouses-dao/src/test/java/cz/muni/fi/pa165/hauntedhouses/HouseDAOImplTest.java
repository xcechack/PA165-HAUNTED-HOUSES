package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.jpa.HouseDAOImpl;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.field.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Markéta Kružliaková
 */
public class HouseDAOImplTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static House house;
    public static HouseDAOImpl houseManager;
    
    @Before
    public void setUp() {
        try {
            emf = Persistence.createEntityManagerFactory("HauntedHousesDB");
        } catch (Exception e) {
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        
        house = new House();
        house.setName("Old Hospital");
        house.setHistory("The Hospital was destroyed in 1920.");
        Address address = new Address();
        address.setCity("Prague");
        address.setHouseNumber(22);
        address.setPostalCode(60510);
        address.setStreet("Hlavni");
        house.setAddress(address);
        
        try {
            em.getTransaction().begin();
            em.persist(house);
            em.getTransaction().commit();
        } catch (Exception e) {
            fail("Could not commit Persistence.");
        }
        
        houseManager = new HouseDAOImpl();
        houseManager.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
    List<House> houses = houseManager.getAllHouses();
        for (House h : houses) {
            houseManager.deleteHouse(h);
        }
        if (em.isOpen()) {
            em.close();
        }
    }
    
    @Test
    @Transactional
    public void testAddHouse() {
        House house1 = new House();
        house1.setName("Haunted House");
        house1.setHistory("The Hospital was built in 1860.");
        Address address = new Address();
        address.setCity("Brno");
        address.setHouseNumber(35);
        address.setPostalCode(60500);
        address.setStreet("Josefska");
        house1.setAddress(address);
        
        System.out.println(house1.getId());
        assertNull("ID must be null.", house1.getId());
        houseManager.addHouse(house1);
        assertNotNull("ID can not be null.", house1.getId());
    }
    
    @Test
    @Transactional
    public void testUpdateHouse() {
        house.setName("Old Psychiatric Hospital");
        houseManager.updateHouse(house);
        House house1 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house1));
    }
    
    @Test
    @Transactional
    public void testDeleteHouse() {
        assertNotNull("ID can not be null.", house.getId());
        houseManager.deleteHouse(house);
        Assert.assertNull("ID must be null after removing.", houseManager.getHouseById(house.getId()));
    }
    
    @Test
    @Transactional
    public void testGetAllHouses() {
	List<House> houses = houseManager.getAllHouses();
	Assert.assertEquals(1, houses.size());
    }
    
    @Test
    @Transactional
    public void testGetHouseById() {
        House house1 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house1));
    }
    
}