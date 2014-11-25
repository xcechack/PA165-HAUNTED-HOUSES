package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerManager;
import cz.muni.fi.pa165.hauntedhouses.service.services.jpa.PowerManagerImpl;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jana Cechackova
 */
public class PowerManagerTest {
    private DozerBeanMapper dozerBeanMapper;
    private PowerManager powerManager; 
    private PowerDTO powerDTO;
    private Power power;
    
    @Mock
    PowerDAO powerDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        powerManager = new PowerManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        powerDTO = new PowerDTO();
        powerDTO.setId(1l);
        powerDTO.setDescription("some description");
        powerDTO.setName("some name");
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
    public void getAllPowers(){
        powerManager.addPower(powerDTO);
        powerManager.getAllPowers();
        verify(powerDAO).getAllPowers();
    }
    
    @Test
    public void getPowerById(){
        powerManager.addPower(powerDTO);
        powerManager.getPowerById(1l);
        verify(powerDAO).getPowerById(1l);
    }
}
