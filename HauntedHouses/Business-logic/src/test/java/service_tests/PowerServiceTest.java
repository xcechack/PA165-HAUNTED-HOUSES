package service_tests;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerService;
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
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author Jana Cechackova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class PowerServiceTest {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private PowerService powerService;
    @Autowired
    private PowerDTO powerDTO;
    private Power power;
    
    @Mock
    PowerDAO powerDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(powerService, "powerDAO", powerDAO);
        power = dozerBeanMapper.map(powerDTO, Power.class);
    }
    
    @Test
    public void testAddPower(){
        powerService.addPower(powerDTO);
        verify(powerDAO).addPower(power);
        powerService.deletePower(powerDTO);
    }
    
    @Test
    public void testUpdatePower(){
        powerService.addPower(powerDTO);
        powerDTO.setId(2l);
        power = dozerBeanMapper.map(powerDTO, Power.class);
        powerService.updatePower(powerDTO);
        verify(powerDAO).updatePower(power);
        powerService.deletePower(powerDTO);
    }
    
    @Test
    public void testDeletePower(){
        powerService.addPower(powerDTO);
        powerService.deletePower(powerDTO);
        verify(powerDAO).deletePower(power);        
    }
    
    @Test
    public void testGetAllPowers(){
        powerService.addPower(powerDTO);
        powerService.getAllPowers();
        verify(powerDAO).getAllPowers();
    }
    
    @Test
    public void testGetPowerById(){
        powerService.addPower(powerDTO);
        powerService.getPowerById(1l);
        verify(powerDAO).getPowerById(1l);
        powerService.deletePower(powerDTO);
    }
}
