package dao_tests;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import javax.transaction.Transactional;
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
public class PowerDAOImplTest {

    @Autowired
    public Power power;
    
    @Autowired
    public PowerDAO powerManager;
   
    @Test
    public void testAddPower() {
        int size = powerManager.getAllPowers().size();
        powerManager.addPower(power);
        Assert.assertTrue("Size should be +1 now.", powerManager.getAllPowers().size() == size+1);
        powerManager.deletePower(power);
    }
    
    @Test
    public void testUpdatePower() {
        powerManager.addPower(power);
        power.setName("differentname");
        powerManager.updatePower(power);
        Power power1 = powerManager.getPowerById(power.getId());
        Assert.assertTrue(power.equals(power1));
        powerManager.deletePower(power);
    }
    
    @Test
    public void testDeletePower() {
        int size = powerManager.getAllPowers().size();
        powerManager.addPower(power);
        Assert.assertTrue("Size should be +1 now.", powerManager.getAllPowers().size()==size+1);
        powerManager.deletePower(power);
        Assert.assertTrue("Size should be back to original number now.", powerManager.getAllPowers().size()==size);
    }
    
    @Test
    public void testGetAllPowers() {
        powerManager.addPower(power);
	Assert.assertEquals(1, powerManager.getAllPowers().size());
        powerManager.deletePower(power);
    }
    
    @Test
    public void testGetPowerById() {
        powerManager.addPower(power);
        Power power1 = powerManager.getPowerById(power.getId());
        Assert.assertTrue(power.equals(power1));
        powerManager.deletePower(power);
    }
        
}
        