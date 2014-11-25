package cz.muni.fi.pa165.hauntedhouses.service;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.GhostManager;
import cz.muni.fi.pa165.hauntedhouses.service.services.jpa.GhostManagerImpl;
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
public class GhostManagerTest {
    private DozerBeanMapper dozerBeanMapper;
    private GhostManager ghostManager; 
    private GhostDTO ghostDTO;
    private Ghost ghost;
    
    @Mock
    GhostDAO ghostDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ghostManager = new GhostManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        ghostDTO = new GhostDTO();
        ghostDTO.setId(1l);
        ghostDTO.setInfo("some info");
        ghostDTO.setName("some name");
        ghostManager.setGhostDAO(ghostDAO);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
    }
    
    @Test
    public void testAddGhost(){
        ghostManager.addGhost(ghostDTO);
        verify(ghostDAO).addGhost(ghost);
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testUpdateGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostDTO.setId(2l);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostManager.updateGhost(ghostDTO);
        verify(ghostDAO).updateGhost(ghost);
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void testDeleteGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.deleteGhost(ghostDTO);
        verify(ghostDAO).deleteGhost(ghost);        
    }
    
    @Test
    public void getAllGhosts(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getAllGhosts();
        verify(ghostDAO).getAllGhosts();
        ghostManager.deleteGhost(ghostDTO);
    }
    
    @Test
    public void getHouseById(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getGhostById(1l);
        verify(ghostDAO).getGhostById(1l);
        ghostManager.deleteGhost(ghostDTO);
    }
}
