package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerManager;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Jana Cechackova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class PowerManagerTest {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private PowerManager powerManager;
    @Autowired
    private PowerDTO powerDTO;
    private Power power;
    
    @Mock
    PowerDAO powerDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        powerManager.setPowerDAO(powerDAO);
        power = dozerBeanMapper.map(powerDTO, Power.class);
    }
    
    @Test
    public void testAddPower(){
        powerManager.addPower(powerDTO);
        verify(powerDAO).addPower(power);
        powerManager.deletePower(powerDTO);
    }
    
    @Test
    public void testUpdatePower(){
        powerManager.addPower(powerDTO);
        powerDTO.setId(2l);
        power = dozerBeanMapper.map(powerDTO, Power.class);
        powerManager.updatePower(powerDTO);
        verify(powerDAO).updatePower(power);
        powerManager.deletePower(powerDTO);
    }
    
    @Test
    public void testDeletePower(){
        powerManager.addPower(powerDTO);
        powerManager.deletePower(powerDTO);
        verify(powerDAO).deletePower(power);        
    }
    
    @Test
    public void testGetAllPowers(){
        powerManager.addPower(powerDTO);
        powerManager.getAllPowers();
        verify(powerDAO).getAllPowers();
    }
    
    @Test
    public void testGetPowerById(){
        powerManager.addPower(powerDTO);
        powerManager.getPowerById(1l);
        verify(powerDAO).getPowerById(1l);
        powerManager.deletePower(powerDTO);
    }
}
