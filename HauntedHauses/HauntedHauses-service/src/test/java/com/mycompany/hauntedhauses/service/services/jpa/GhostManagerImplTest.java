/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.GhostDAO;
import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.service.dto.GhostDTO;
import com.mycompany.hauntedhauses.service.services.GhostManager;
import java.sql.Timestamp;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author Michal Zbranek
 */

public class GhostManagerImplTest {
    private DozerBeanMapper dozerBeanMapper;
    private GhostManager ghostManager; 
    private GhostDTO ghostDTO;
    private Ghost ghost;
    
    @Mock
    GhostDAO ghostDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        ghostManager = new GhostManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        ghostManager.setGhostDAO(ghostDAO);
        ghostManager.setDozerBeanMapper(dozerBeanMapper);
        
        ghostDTO = new GhostDTO();
        ghostDTO.setId(1);
        ghostDTO.setName("Aether");
        long timeL = System.currentTimeMillis();
        Timestamp startTime = new Timestamp(timeL);
        Timestamp endTime = new Timestamp(timeL+3600000);
        ghostDTO.setStartTime(startTime);
        ghostDTO.setEndTime(endTime);
        ghostDTO.setInfo("Weather based ghost");
        
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);

    }   
    
    @Test
    public void testCreateGhost() {               
        ghostManager.addGhost(ghostDTO);
        Ghost ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        Mockito.verify(ghostDAO).addGhost(ghost);
    }
    
    @Test
    public void testDeleteGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.deleteGhost(ghostDTO);
        verify(ghostDAO).deleteGhost(ghost);        
    }
    
    @Test
    public void testUpdateGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostDTO.setId(10);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostManager.updateGhost(ghostDTO);
        verify(ghostDAO).updateGhost(ghost);        
    }
    
    @Test
    public void getAllGhosts(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getAllGhosts();
        verify(ghostDAO).getAllGhosts();
    }
    
    @Test
    public void getGhostByID(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.getGhostByID(1);
        verify(ghostDAO).getGhostByID(1);
    }
    
 
}

   