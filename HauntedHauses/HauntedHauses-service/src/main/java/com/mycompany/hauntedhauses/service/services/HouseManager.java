/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services;

import com.mycompany.hauntedhauses.service.dto.HouseDTO;
import java.util.List;

/**
 *
 * @author Gabriela Podolnikova
 */
public interface HouseManager {
   
    public void addHouse(HouseDTO houseDTO);
    
    public void deleteHouse(HouseDTO houseDTO);
    
    public void updateHouse(HouseDTO houseDTO);
    
    public List<HouseDTO> getAllHouses();
    
    public HouseDTO getHouseById(Long id);
}
