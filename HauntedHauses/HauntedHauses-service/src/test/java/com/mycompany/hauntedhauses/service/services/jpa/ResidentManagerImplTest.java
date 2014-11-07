/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.jpa.ResidentDAOImpl;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.dto.ResidentDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.dozer.DozerBeanMapper;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author Market
 */

public class ResidentManagerImplTest {
    
   
    private ResidentManagerImpl residentManager;
    private ResidentDTO residentDTO;
    private Resident resident;
    
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    
    @Mock
    private ResidentDAOImpl residentDAO = mock(ResidentDAOImpl.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        residentManager = new ResidentManagerImpl(dozerBeanMapper);
        residentManager.setResidentDAO(residentDAO);

        
        residentDTO = new ResidentDTO();
        residentDTO.setId(1);
        residentDTO.setFirstName("Anna");
        residentDTO.setLastName("Novakova");  
        residentDTO.setAge(20);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
    }   
    
    @Test
    public void testCreateResident() {               
        residentManager.addResident(residentDTO);
        Resident resident = dozerBeanMapper.map(residentDTO, Resident.class);
        Mockito.verify(residentDAO).addResident(resident);
    }
    
    @Test
    public void testDeleteResident(){
        residentManager.addResident(residentDTO);
        residentManager.deleteResident(residentDTO);
        verify(residentDAO).deleteResident(resident);        
    }
    
    @Test
    public void testUpdateResident(){
        residentManager.addResident(residentDTO);
        
        // Now we have to change "powerDTO" somehow and then map "power" again
        residentDTO.setId(10);
        resident = dozerBeanMapper.map(residentDTO, Resident.class);
        residentManager.updateResident(residentDTO);
        verify(residentDAO).updateResident(resident);        
    }
    
    @Test
    public void getAllResidents(){
        residentManager.addResident(residentDTO);
        residentManager.getAllResidents();
        verify(residentDAO).getAllResidents();
    }
    
    @Test
    public void getResidentByID(){
        residentManager.addResident(residentDTO);
        residentManager.getResidentByID(1);
        verify(residentDAO).getResidentByID(1);
    }
    
 
}

   