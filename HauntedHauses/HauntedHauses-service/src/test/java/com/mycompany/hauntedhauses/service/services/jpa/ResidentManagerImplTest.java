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
import org.mockito.MockitoAnnotations;


/**
 *
 * @author Market
 */

public class ResidentManagerImplTest {
    
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    
    @Mock
    private ResidentDAOImpl residentDAO = mock(ResidentDAOImpl.class);

    @InjectMocks
    private ResidentManagerImpl residentManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        residentManager = new ResidentManagerImpl(dozerBeanMapper);
        residentManager.setResidentDAO(residentDAO);
    }   
    
    @After
    public void tearDown() {
        residentDAO = null;
        residentManager = null;
    }
/*
    @Test
    public void testCreateResident() {
        ResidentDTO residentDTO = new ResidentDTO();
        residentDTO.setFirstName("Anna");
        residentDTO.setLastName("Novakova");
        residentDTO.setAge(12);
               
        residentManager.addResident(residentDTO);
        Resident resident = dozerBeanMapper.map(residentDTO, Resident.class);
        Mockito.verify(residentDAO).addResident(resident);
    }
*/  
}

   