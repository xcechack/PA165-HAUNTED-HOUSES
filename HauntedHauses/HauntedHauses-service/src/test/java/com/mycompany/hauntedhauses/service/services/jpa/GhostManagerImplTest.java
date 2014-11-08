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
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 * @author Michal Zbranek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationcontext.xml"})
public class GhostManagerImplTest {
    @Mock
    private GhostDAO ghostDAO;
    
    private GhostManager ghostManager;
    
    @Autowired
    private GhostDTO ghostDTO;
    
    private DozerBeanMapper dozerBeanMapper;
    
    private Ghost ghost;
    
    @Autowired
    private Mapper mapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        ghostManager = new GhostManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        ghostManager.setGhostDAO(ghostDAO);
        ghostManager.setDozerBeanMapper(dozerBeanMapper);
        
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);

    }   
    
    @Test
    public void testCreateGhost() {               
        ghostManager.addGhost(ghostDTO);
        Mockito.verify(ghostDAO).addGhost(ghost);
    }
    
    @Test
    public void testDeleteGhost(){
        ghostManager.addGhost(ghostDTO);
        ghostManager.deleteGhost(ghostDTO);
        verify(ghostDAO).deleteGhost(mapper.map(ghostDTO, Ghost.class));        
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
        ghostDTO.setId(1);
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostManager.updateGhost(ghostDTO);
        ghostManager.getGhostByID(1);
        verify(ghostDAO).getGhostByID(1);
    }
    
 
}

   