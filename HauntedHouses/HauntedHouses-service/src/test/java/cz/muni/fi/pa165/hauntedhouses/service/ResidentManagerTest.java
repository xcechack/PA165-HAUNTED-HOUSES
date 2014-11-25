package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.ResidentManager;
import cz.muni.fi.pa165.hauntedhouses.service.services.jpa.ResidentManagerImpl;
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
public class ResidentManagerTest {
    private DozerBeanMapper dozerBeanMapper;
    private ResidentManager residentManager; 
    private ResidentDTO residentDTO;
    private Resident resident;
    
    @Mock
    ResidentDAO residentDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        residentManager = new ResidentManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        residentDTO = new ResidentDTO();
        residentDTO.setId(1l);
        residentDTO.setAge(25);
        residentDTO.setFirstName("Petr");
        residentDTO.setLastName("Potloukal");
        residentManager.setResidentDAO(residentDAO);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
    }
    
    @Test
    public void testAddResident(){
        residentManager.addResident(residentDTO);
        verify(residentDAO).addResident(resident);
        residentManager.deleteResident(residentDTO);
    }
    
    @Test
    public void testUpdateResident(){
        residentManager.addResident(residentDTO);
        residentDTO.setId(2l);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
        residentManager.updateResident(residentDTO);
        verify(residentDAO).updateResident(resident);
        residentManager.deleteResident(residentDTO);
    }
    
    @Test
    public void testDeleteResident(){
        residentManager.addResident(residentDTO);
        residentManager.deleteResident(residentDTO);
        verify(residentDAO).deleteResident(resident);        
    }
    
    @Test
    public void testGetAllResidents(){
        residentManager.addResident(residentDTO);
        residentManager.getAllResidents();
        verify(residentDAO).getAllResidents();
    }
    
    @Test
    public void testGetPowerById(){
        residentManager.addResident(residentDTO);
        residentManager.getResidentById(1l);
        verify(residentDAO).getResidentById(1l);
        residentManager.deleteResident(residentDTO);
    }
}
