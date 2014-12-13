package service_tests;


import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.GhostService;
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
public class GhostServiceTest {
    @Mock
    GhostDAO ghostDAO;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private GhostService ghostService; 
    @Autowired
    private GhostDTO ghostDTO;
    private Ghost ghost;
    
    
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(ghostService, "ghostDAO", ghostDAO);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
    }
    
    @Test
    public void testAddGhost(){
        ghostService.addGhost(ghostDTO);
        verify(ghostDAO).addGhost(ghost);
        ghostService.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testUpdateGhost(){
        ghostService.addGhost(ghostDTO);
        ghostDTO.setId(2l);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostService.updateGhost(ghostDTO);
        verify(ghostDAO).updateGhost(ghost);
        ghostService.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testDeleteGhost(){
        ghostService.addGhost(ghostDTO);
        ghostService.deleteGhost(ghostDTO);
        verify(ghostDAO).deleteGhost(ghost);        
    }
    
    @Test
    public void testGetAllGhosts(){
        ghostService.addGhost(ghostDTO);
        ghostService.getAllGhosts();
        verify(ghostDAO).getAllGhosts();
        ghostService.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testGetGhostById(){
        ghostService.addGhost(ghostDTO);
        ghostService.getGhostById(1l);
        verify(ghostDAO).getGhostById(1l);
        ghostService.deleteGhost(ghostDTO);
    }
}
