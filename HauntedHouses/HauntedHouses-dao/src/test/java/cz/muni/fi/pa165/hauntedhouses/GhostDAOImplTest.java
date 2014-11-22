package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.jpa.GhostDAOImpl;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
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
 * @author Gabriela Podolnikova
 */
public class GhostDAOImplTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static Ghost ghost;
    public static GhostDAOImpl ghostManager;
    
    @Before
    public void setUp() {
        try {
            emf = Persistence.createEntityManagerFactory("HauntedHousesDB");
        } catch (Exception e) {
            fail("Could not initialize Persistence.");
        }
        em = emf.createEntityManager();
        
        ghost = new Ghost();
        ghost.setName("Bubak");
        
        try {
            em.getTransaction().begin();
            em.persist(ghost);
            em.getTransaction().commit();
        } catch (Exception e) {
            fail("Could not commit Persistence.");
        }
        
        ghostManager = new GhostDAOImpl();
        ghostManager.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
    List<Ghost> ghosts = ghostManager.getAllGhosts();
        for (Ghost g : ghosts) {
            ghostManager.deleteGhost(g);
        }
        if (em.isOpen()) {
            em.close();
        }
    }
    
    @Test
    @Transactional
    public void testAddGhost() {
        Ghost ghost1 = new Ghost();
        ghost1.setName("Strasidlo");
        
        assertNull("ID must be null.", ghost1.getId());
        ghostManager.addGhost(ghost1);
        assertNotNull("ID can not be null.", ghost1.getId());
    }
    
    @Test
    @Transactional
    public void testUpdateGhost() {
        ghost.setName("Duch");
        ghostManager.updateGhost(ghost);
        Ghost ghost1 = ghostManager.getGhostById(ghost.getId());
        Assert.assertTrue(ghost.equals(ghost1));
    }
    
    @Test
    @Transactional
    public void testDeleteGhost() {
        assertNotNull("ID can not be null.", ghost.getId());
        ghostManager.deleteGhost(ghost);
        Assert.assertNull("ID must be null after removing.", ghostManager.getGhostById(ghost.getId()));
    }
    
    @Test
    @Transactional
    public void testGetAllGhosts() {
	List<Ghost> ghosts = ghostManager.getAllGhosts();
	Assert.assertEquals(1, ghosts.size());
    }
    
    @Test
    @Transactional
    public void testGetGhostById() {
        Ghost ghost1 = ghostManager.getGhostById(ghost.getId());
        Assert.assertTrue(ghost.equals(ghost1));
    }
    
}
