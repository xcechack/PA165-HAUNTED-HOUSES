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
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Gabriela Podolnikova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class GhostManagerTest {
    @Mock
    GhostDAO ghostDAO;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private GhostService ghostManager; 
    @Autowired
    private GhostDTO ghostDTO;
    private Ghost ghost;
    
    
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
    }
    
    @Test
    public void testAddGhost(){
        ghostManager.addGhost(ghostDTO);
//        verify(ghostDAO).addGhost(ghost);
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testUpdateGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostDTO.setId(2l);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostManager.updateGhost(ghostDTO);
//        verify(ghostDAO).updateGhost(ghost);
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testDeleteGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.deleteGhost(ghostDTO);
//        verify(ghostDAO).deleteGhost(ghost);        
    }
    
    @Test
    public void testGetAllGhosts(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getAllGhosts();
//        verify(ghostDAO).getAllGhosts();
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testGetGhostById(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getGhostById(1l);
////        verify(ghostDAO).getGhostById(1l);
        ghostManager.deleteGhost(ghostDTO);
    }
}
