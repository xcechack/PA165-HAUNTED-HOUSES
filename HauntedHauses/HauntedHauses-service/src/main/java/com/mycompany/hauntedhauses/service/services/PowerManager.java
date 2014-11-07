/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services;

import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.service.dto.PowerDTO;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Jana Cechackova
 */
public interface PowerManager {
        
    public void addPower(PowerDTO powerDTO);
    public void updatePower(PowerDTO powerDTO);
    public void deletePower(PowerDTO powerDTO);
    public List<PowerDTO> getAllPowers();
    public PowerDTO getPowerById(int id);
    public void setPowerDAO(PowerDAO powerDAO);
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper);
}
