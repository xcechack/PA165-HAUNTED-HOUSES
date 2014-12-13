package service_tests;

import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.service.dto.HouseDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.HouseService;
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
 * @author Gabriela Podolnikova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class HouseServiceTest {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private HouseService houseService; 
    @Autowired
    private HouseDTO houseDTO;
    private House house;
    
    @Mock
    HouseDAO houseDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(houseService, "houseDAO", houseDAO);
        house = dozerBeanMapper.map(houseDTO, House.class);
    }
    
    @Test
    public void testAddHouse(){
        houseService.addHouse(houseDTO);
        verify(houseDAO).addHouse(house);
        houseService.deleteHouse(houseDTO);
    }
    
    @Test
    public void testUpdateHouse(){
        houseService.addHouse(houseDTO);
        houseDTO.setId(2l);
        house = dozerBeanMapper.map(houseDTO, House.class);
        houseService.updateHouse(houseDTO);
        verify(houseDAO).updateHouse(house);
        houseService.deleteHouse(houseDTO);
    }
    
    @Test
    public void testDeleteHouse(){
        houseService.addHouse(houseDTO);
        houseService.deleteHouse(houseDTO);
        verify(houseDAO).deleteHouse(house);        
    }
    
    @Test
    public void testGetAllHouses(){
        houseService.addHouse(houseDTO);
        houseService.getAllHouses();
        verify(houseDAO).getAllHouses();
    }
    
    @Test
    public void testGetHouseById(){
        houseService.addHouse(houseDTO);
        houseService.getHouseById(1l);
        verify(houseDAO).getHouseById(1l);
        houseService.deleteHouse(houseDTO);
    }
}
