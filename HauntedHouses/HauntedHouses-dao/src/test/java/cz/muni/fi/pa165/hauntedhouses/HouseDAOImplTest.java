package cz.muni.fi.pa165.hauntedhouses;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
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
public class HouseDAOImplTest {

    @Autowired
    public House house;
    
    @Autowired
    public HouseDAO houseManager;
   
    @Test
    @Transactional
    public void testAddHouse() {
        int size = houseManager.getAllHouses().size();
        houseManager.addHouse(house);
        Assert.assertTrue("Size should be +1 now.", houseManager.getAllHouses().size() == size+1);
        houseManager.deleteHouse(house);
    }
    
    @Test
    @Transactional
    public void testUpdateHouse() {
        houseManager.addHouse(house);
        house.setName("differentname");
        houseManager.updateHouse(house);
        House house1 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house));
        houseManager.deleteHouse(house);
    }
    
    @Test
    @Transactional
    public void testDeleteHouse() {
        int size = houseManager.getAllHouses().size();
        houseManager.addHouse(house);
        Assert.assertTrue("Size should be +1 now.", houseManager.getAllHouses().size()==size+1);
        houseManager.deleteHouse(house);
        Assert.assertTrue("Size should be back to original number now.", houseManager.getAllHouses().size()==size);
    }
    
    @Test
    @Transactional
    public void testGetAllHouses() {
        houseManager.addHouse(house);
	Assert.assertEquals(1, houseManager.getAllHouses().size());
        houseManager.deleteHouse(house);
    }
    
    @Test
    @Transactional
    public void testGetHouseById() {
        houseManager.addHouse(house);
        House house1 = houseManager.getHouseById(house.getId());
        Assert.assertTrue(house.equals(house1));
        houseManager.deleteHouse(house);
    }
    
}