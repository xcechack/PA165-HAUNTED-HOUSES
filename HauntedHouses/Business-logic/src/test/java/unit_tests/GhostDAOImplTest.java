package unit_tests;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Gabriela Podolnikova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class GhostDAOImplTest {

    @Autowired
    public Ghost ghost;
    
    @Autowired
    public GhostDAO ghostManager;
   
    @Test
    public void testAddGhost() {
        int size = ghostManager.getAllGhosts().size();
        ghostManager.addGhost(ghost);
        Assert.assertTrue("Size should be +1 now.", ghostManager.getAllGhosts().size() == size+1);
        ghostManager.deleteGhost(ghost);
    }
    
    @Test
    public void testUpdateGhost() {
        ghostManager.addGhost(ghost);
        ghost.setName("differentname");
        ghostManager.updateGhost(ghost);
        Ghost ghost1 = ghostManager.getGhostById(ghost.getId());
        Assert.assertTrue(ghost.equals(ghost1));
        ghostManager.deleteGhost(ghost);
    }
    
    @Test
    public void testDeleteGhost() {
        int size = ghostManager.getAllGhosts().size();
        ghostManager.addGhost(ghost);
        Assert.assertTrue("Size should be +1 now.", ghostManager.getAllGhosts().size()==size+1);
        ghostManager.deleteGhost(ghost);
        Assert.assertTrue("Size should be back to original number now.", ghostManager.getAllGhosts().size()==size);
    }
    
    @Test
    public void testGetAllGhosts() {
        ghostManager.addGhost(ghost);
	Assert.assertEquals(1, ghostManager.getAllGhosts().size());
        ghostManager.deleteGhost(ghost);
    }
    
    @Test
    public void testGetGhostById() {
        ghostManager.addGhost(ghost);
        Ghost ghost1 = ghostManager.getGhostById(ghost.getId());
        Assert.assertTrue(ghost.equals(ghost1));
        ghostManager.deleteGhost(ghost);
    }
    
}