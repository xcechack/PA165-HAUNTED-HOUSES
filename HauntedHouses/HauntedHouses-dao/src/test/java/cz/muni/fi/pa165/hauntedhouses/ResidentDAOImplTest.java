package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.jpa.ResidentDAOImpl;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
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
 * @author Michal Zbranek
 */
public class ResidentDAOImplTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static Resident resident;
    public static ResidentDAOImpl residentManager;
    
    @Before
    public void setUp() {
        try {
            emf = Persistence.createEntityManagerFactory("HauntedHousesDB");
        } catch (Exception e) {
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        
        resident = new Resident();
        
        resident.setFirstName("Michal");
        resident.setLastName("Zbranek");
        resident.setAge(22);
        
        try {
            em.getTransaction().begin();
            em.persist(resident);
            em.getTransaction().commit();
        } catch (Exception e) {
            fail("Could not commit Persistence.");
        }
        
        residentManager = new ResidentDAOImpl();
        residentManager.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
    List<Resident> residents = residentManager.getAllResidents();
        for (Resident r : residents) {
            residentManager.deleteResident(r);
        }
        if (em.isOpen()) {
            em.close();
        }
    }
    
    @Test
    @Transactional
    public void testAddResident() {
        Resident resident1 = new Resident();
        resident1.setFirstName("Anna");
        resident1.setLastName("Nova");
        resident1.setAge(20);
        
        assertNull("ID must be null.", resident1.getId());
        residentManager.addResident(resident1);
        assertNotNull("ID can not be null.", resident1.getId());
    }
    
    @Test
    @Transactional
    public void testUpdateResident() {
        resident.setFirstName("David");
        residentManager.updateResident(resident);
        Resident resident1 = residentManager.getResidentById(resident.getId());
        Assert.assertTrue(resident.equals(resident1));
    }
    
    @Test
    @Transactional
    public void testDeleteResident() {
        assertNotNull("ID can not be null.", resident.getId());
        residentManager.deleteResident(resident);
        Assert.assertNull("ID must be null after removing.", residentManager.getResidentById(resident.getId()));
    }
    
    @Test
    @Transactional
    public void testGetAllResidents() {
	List<Resident> residents = residentManager.getAllResidents();
	Assert.assertEquals(1, residents.size());
    }
    
    @Test
    @Transactional
    public void testGetResidentById() {
        Resident resident1 = residentManager.getResidentById(resident.getId());
        Assert.assertTrue(resident.equals(resident1));
    }
    
}
