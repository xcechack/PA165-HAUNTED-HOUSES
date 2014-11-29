package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
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
public class ResidentDAOImplTest {

    @Autowired
    public Resident resident;
    
    @Autowired
    public ResidentDAO residentManager;
   
    @Test
    public void testAddResident() {
        int size = residentManager.getAllResidents().size();
        residentManager.addResident(resident);
        Assert.assertTrue("Size should be +1 now.", residentManager.getAllResidents().size() == size+1);
        residentManager.deleteResident(resident);
    }
        
}