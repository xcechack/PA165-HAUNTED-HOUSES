/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.service.dto.PowerDTO;
import com.mycompany.hauntedhauses.service.services.PowerManager;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jana Cechackova
 */
public class PowerManagerTest {
    private DozerBeanMapper dozerBeanMapper;
    private PowerManager powerManager; 
    private PowerDTO powerDTO;
    private Power power;
    
    @Mock
    PowerDAO powerDAO;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        
        powerManager = new PowerManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        powerManager.setPowerDAO(powerDAO);
        powerManager.setDozerBeanMapper(dozerBeanMapper);
        
        powerDTO = new PowerDTO();
        powerDTO.setId(1);
        powerDTO.setDescription("some description");
        powerDTO.setName("some name");  
        power = dozerBeanMapper.map(powerDTO, Power.class);
    }
    
    @Test
    public void testAddPower(){
        /** You can try to add power2 and test will fail.
        PowerDTO power2DTO = new PowerDTO();
        power2DTO.setId(2);
        Power power2 = dozerBeanMapper.map(power2DTO, Power.class);  */
 
        powerManager.addPower(powerDTO);
        verify(powerDAO).addPower(power);
//        powerManager.deletePower(powerDTO);
    }
    
    @Test
    public void testUpdatePower(){
        powerManager.addPower(powerDTO);
        
        // Now we have to change "powerDTO" somehow and then map "power" again
        powerDTO.setId(2);
        power = dozerBeanMapper.map(powerDTO, Power.class);
        powerManager.updatePower(powerDTO);
        verify(powerDAO).updatePower(power);        
    }
    
    @Test
    public void testDeletePower(){
        powerManager.addPower(powerDTO);
        powerManager.deletePower(powerDTO);
        verify(powerDAO).deletePower(power);        
    }
    
    @Test
    public void getAllPowers(){
        powerManager.addPower(powerDTO);
        powerManager.getAllPowers();
        verify(powerDAO).getAllPowers();
    }
    
    @Test
    public void getPowerById(){
        powerManager.addPower(powerDTO);
        powerManager.getPowerById(1);
        verify(powerDAO).getPowerByID(1);
    }
}
