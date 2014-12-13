package service_tests;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.ResidentService;
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
public class ResidentServiceTest {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private ResidentService residentService; 
    @Autowired
    private ResidentDTO residentDTO;
    private Resident resident;
    
    @Mock
    ResidentDAO residentDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(residentService, "residentDAO", residentDAO);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
    }
    
    @Test
    public void testAddResident(){
        residentService.addResident(residentDTO);
        verify(residentDAO).addResident(resident);
        residentService.deleteResident(residentDTO);
    }
    
    @Test
    public void testUpdateResident(){
        residentService.addResident(residentDTO);
        residentDTO.setId(2l);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
        residentService.updateResident(residentDTO);
        verify(residentDAO).updateResident(resident);
        residentService.deleteResident(residentDTO);
    }
    
    @Test
    public void testDeleteResident(){
        residentService.addResident(residentDTO);
        residentService.deleteResident(residentDTO);
        verify(residentDAO).deleteResident(resident);        
    }
    
    @Test
    public void testGetAllResidents(){
        residentService.addResident(residentDTO);
        residentService.getAllResidents();
        verify(residentDAO).getAllResidents();
    }
    
    @Test
    public void testGetResidentById(){
        residentService.addResident(residentDTO);
        residentService.getResidentById(1l);
        verify(residentDAO).getResidentById(1l);
        residentService.deleteResident(residentDTO);
    }
}
