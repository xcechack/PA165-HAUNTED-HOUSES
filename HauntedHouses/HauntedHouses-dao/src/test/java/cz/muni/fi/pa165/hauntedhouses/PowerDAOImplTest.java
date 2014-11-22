package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.jpa.PowerDAOImpl;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
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
 * @author Jana Cechackova
 */
public class PowerDAOImplTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static Power power;
    public static PowerDAOImpl powerManager;
    
    @Before
    public void setUp() {
        try {
            emf = Persistence.createEntityManagerFactory("HauntedHousesDB");
        } catch (Exception e) {
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        
        power = new Power();
        power.setName("Fire");
        
        try {
            em.getTransaction().begin();
            em.persist(power);
            em.getTransaction().commit();
        } catch (Exception e) {
            fail("Could not commit Persistence.");
        }
        
        powerManager = new PowerDAOImpl();
        powerManager.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
    List<Power> powers = powerManager.getAllPowers();
        for (Power p : powers) {
            powerManager.deletePower(p);
        }
        if (em.isOpen()) {
            em.close();
        }
    }
    
    @Test
    @Transactional
    public void testAddPower() {
        Power power1 = new Power();
        power1.setName("Teleportation");
        
        assertNull("ID must be null.", power1.getId());
        powerManager.addPower(power1);
        assertNotNull("ID can not be null.", power1.getId());
    }
    
    @Test
    @Transactional
    public void testUpdatePower() {
        power.setName("Invisibility");
        powerManager.updatePower(power);
        Power power1 = powerManager.getPowerById(power.getId());
        Assert.assertTrue(power.equals(power1));
    }
    
    @Test
    @Transactional
    public void testDeletePower() {
        assertNotNull("ID can not be null.", power.getId());
        powerManager.deletePower(power);
        Assert.assertNull("ID must be null after removing.", powerManager.getPowerById(power.getId()));
    }
    
    @Test
    @Transactional
    public void testGetAllPowers() {
	List<Power> powers = powerManager.getAllPowers();
	Assert.assertEquals(1, powers.size());
    }
    
    @Test
    @Transactional
    public void testGetPowerById() {
        Power power1 = powerManager.getPowerById(power.getId());
        Assert.assertTrue(power.equals(power1));
    }
    
}
