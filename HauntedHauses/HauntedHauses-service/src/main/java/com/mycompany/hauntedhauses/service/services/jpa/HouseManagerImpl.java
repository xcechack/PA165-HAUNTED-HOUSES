/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.HouseDAO;
import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.service.dto.HouseDTO;
import com.mycompany.hauntedhauses.service.services.HouseManager;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseManagerImpl implements HouseManager {
    
    HouseDAO houseDAO;
    DozerBeanMapper dozerBeanMapper;

    @Override
    public void addHouse(HouseDTO houseDTO) {
        
        House house = dozerBeanMapper.map(houseDTO, House.class);

        try {
            houseDAO.addHouse(house);    
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void updateHouse(HouseDTO houseDTO) {
        
        House house = dozerBeanMapper.map(houseDTO, House.class);
        
        try{
            houseDAO.updateHouse(house);
        
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void deleteHouse(HouseDTO houseDTO) {
        
        House house;
        
        if (houseDTO == null) {
            throw new IllegalArgumentException("House ID is null.");
        }  
        else {
            house = dozerBeanMapper.map(houseDTO, House.class);
        }     
        try {
            houseDAO.deleteHouse(house);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};                
        }    
    }

    @Override
    public List<HouseDTO> getAllHouses() {
        
        List <HouseDTO> housesDTO = null;
        List <House> houses = null;
        
        try{
            houses = houseDAO.getAllHouses();             
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
        if (houses != null) {
            for (House h : houses) {
                HouseDTO houseDTO = dozerBeanMapper.map(h, HouseDTO.class);
                housesDTO.add(houseDTO);
            }
        }
        return housesDTO;
    }

    @Override
    public HouseDTO getHouseById(long id) {
        
       House house; 
       HouseDTO houseDTO = null;
       
        try {
            house = houseDAO.getHouseById(id);               
         
            if (house != null) {
                houseDTO = dozerBeanMapper.map(house, HouseDTO.class); 
            }
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {}; 
        }
        return houseDTO;
    }
    
    @Inject
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper){
        this.dozerBeanMapper = dozerBeanMapper;
    }
    
    public DozerBeanMapper getDozerBeanMapper(){
        return dozerBeanMapper;
    }
    
    public void setHouseDAO(HouseDAO houseDAO){
        this.houseDAO = houseDAO;
    }
    
    public HouseDAO getHouseDAO(){
        return houseDAO;
    }
}
