package com.mycompany.hauntedhauses.service.services.jpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.hauntedhauses.dao.HouseDAO;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.service.dto.HouseDTO;
import com.mycompany.hauntedhauses.service.services.HouseManager;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Gabriela Podolnikova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationcontext.xml"})
public class HouseManagerImplTest {
    
    //ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
    
    @Mock
    private HouseDAO houseDAO;
    
    private HouseManager houseManager;
    
    @Autowired
    private HouseDTO houseDTO;
    
    private DozerBeanMapper dozerBeanMapper;
    
    private House house;
    
    @Autowired
    private Mapper mapper;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        houseManager = new HouseManagerImpl();
        dozerBeanMapper = new DozerBeanMapper();
        houseManager.setHouseDAO(houseDAO);
        houseManager.setDozerBeanMapper(dozerBeanMapper);
         
        house = dozerBeanMapper.map(houseDTO, House.class);
    }
    
    @Test
    public void addHouse() {
        houseManager.addHouse(houseDTO);
        verify(houseDAO).addHouse(house);
    }
    
    @Test
    public void deleteHouse() {
        
        houseManager.addHouse(houseDTO);
        Mockito.verify(houseDAO).addHouse(mapper.map(houseDTO, House.class));
        
        houseManager.deleteHouse(houseDTO);
        Mockito.verify(houseDAO).deleteHouse(mapper.map(houseDTO, House.class));
    }
    
    @Test
    public void updateHouse() {
        houseManager.addHouse(houseDTO);
        
        // Now we have to change "powerDTO" somehow and then map "power" again
        houseDTO.setId(10);
        house = dozerBeanMapper.map(houseDTO, House.class);
        houseManager.updateHouse(houseDTO);
        verify(houseDAO).updateHouse(house);  
    }
    
    @Test
    public void getAllHouses() {
        houseManager.addHouse(houseDTO);
        houseManager.getAllHouses();
        verify(houseDAO).getAllHouses();
    }
    
    @Test
    public void getHouseById() {
        houseManager.addHouse(houseDTO);
        houseDTO.setId(1);
        house = dozerBeanMapper.map(houseDTO, House.class);
        houseManager.updateHouse(houseDTO);
        houseManager.getHouseById(1);
        verify(houseDAO).getHouseById(1);
    }
}
