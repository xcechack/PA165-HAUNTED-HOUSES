package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.ResidentManager;
import cz.muni.fi.pa165.hauntedhouses.service.services.jpa.ResidentManagerImpl;
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
 * @author Gabriela Podolnikova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class ResidentManagerTest {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private ResidentManager residentManager; 
    @Autowired
    private ResidentDTO residentDTO;
    private Resident resident;
    
    @Mock
    ResidentDAO residentDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
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
    public void testGetResidentById(){
        residentManager.addResident(residentDTO);
        residentManager.getResidentById(1l);
        verify(residentDAO).getResidentById(1l);
        residentManager.deleteResident(residentDTO);
    }
}
