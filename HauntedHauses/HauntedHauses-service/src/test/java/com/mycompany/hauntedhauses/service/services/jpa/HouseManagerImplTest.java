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
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseManagerImplTest {
    
    //ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
    
    @Mock
    private HouseDAO houseDAO;
    
    private HouseManager houseManager;
    
    @Autowired
    private Mapper mapper;
    
    public HouseManagerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void addHouse() {
    
    }
    
    @Test
    public void deleteHouse() {
        /*HouseDTO houseDTO = new HouseDTO();
        
        houseManager.addHouse(houseDTO);
        Mockito.verify(houseDAO).addHouse(mapper.map(houseDTO, House.class));
        
        houseManager.deleteHouse(houseDTO);
        Mockito.verify(houseDAO).deleteHouse(mapper.map(houseDTO, House.class));*/
    }
    
    @Test
    public void updateHouse() {
        
    }
    
    @Test
    public void getAllHouses() {
        
    }
    
    @Test
    public void getHouseById() {
        
    }
}
