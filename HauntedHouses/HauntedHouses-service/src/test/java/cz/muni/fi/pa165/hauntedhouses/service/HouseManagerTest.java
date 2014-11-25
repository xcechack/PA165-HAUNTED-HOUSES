package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.service.dto.HouseDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.HouseManager;
import cz.muni.fi.pa165.hauntedhouses.service.services.jpa.HouseManagerImpl;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseManagerTest {
    private DozerBeanMapper dozerBeanMapper;
    private HouseManager houseManager; 
    private HouseDTO houseDTO;
    private House house;
    
    @Mock
    HouseDAO houseDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        houseManager = new HouseManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        houseDTO = new HouseDTO();
        houseDTO.setId(1l);
        houseDTO.setHistory("some history");
        houseDTO.setName("some name");
        houseManager.setHouseDAO(houseDAO);
        house = dozerBeanMapper.map(houseDTO, House.class);
    }
    
    @Test
    public void testAddHouse(){
        houseManager.addHouse(houseDTO);
        verify(houseDAO).addHouse(house);
        houseManager.deleteHouse(houseDTO);
    }
    
    @Test
    public void testUpdateHouse(){
        houseManager.addHouse(houseDTO);
        houseDTO.setId(2l);
        house = dozerBeanMapper.map(houseDTO, House.class);
        houseManager.updateHouse(houseDTO);
        verify(houseDAO).updateHouse(house);
        houseManager.deleteHouse(houseDTO);
    }
    
    @Test
    public void testDeleteHouse(){
        houseManager.addHouse(houseDTO);
        houseManager.deleteHouse(houseDTO);
        verify(houseDAO).deleteHouse(house);        
    }
    
    @Test
    public void testGetAllHouses(){
        houseManager.addHouse(houseDTO);
        houseManager.getAllHouses();
        verify(houseDAO).getAllHouses();
    }
    
    @Test
    public void testGetHouseById(){
        houseManager.addHouse(houseDTO);
        houseManager.getHouseById(1l);
        verify(houseDAO).getHouseById(1l);
        houseManager.deleteHouse(houseDTO);
    }
}
