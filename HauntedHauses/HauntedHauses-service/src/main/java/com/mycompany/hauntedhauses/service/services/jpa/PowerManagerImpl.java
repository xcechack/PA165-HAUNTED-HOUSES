package com.mycompany.hauntedhauses.service.services.jpa;

import org.dozer.DozerBeanMapper;
import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.service.dto.PowerDTO;
import com.mycompany.hauntedhauses.service.services.PowerManager;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Jana Cechackova
 */
public class PowerManagerImpl implements PowerManager {
    
    PowerDAO powerDAO;
    DozerBeanMapper dozerBeanMapper;
    
    public void addPower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) power = dozerBeanMapper.map(powerDTO, Power.class);
        //following command has to be in try-catch block - TO DO
            powerDAO.addPower(power);    
    }

    public void updatePower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) power = dozerBeanMapper.map(powerDTO, Power.class);
        //following command has to be in try-catch block - TO DO
            powerDAO.updatePower(power);
    }

    public void deletePower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) power = dozerBeanMapper.map(powerDTO, Power.class);
        //following command has to be in try-catch block - TO DO
            powerDAO.deletePower(power);
    }

    //empty method has to be filled - TO DO
    public List<PowerDTO> getAllPowers() {
        return null;
    }

    public PowerDTO getPowerById(int id) {
        PowerDTO powerDTO = null;
        Power power = powerDAO.getPowerByID(id);
        if (power != null) powerDTO = dozerBeanMapper.map(power, PowerDTO.class);
        return powerDTO;
    }
    
    //methods from this point down are necessary in every service for proper mapping
    @Inject
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper){
        this.dozerBeanMapper = dozerBeanMapper;
    }
    
    public DozerBeanMapper getDozerBeanMapper(){
        return dozerBeanMapper;
    }
    
    public void setPowerDAO(PowerDAO powerDAO){
        this.powerDAO = powerDAO;
    }
    
    public PowerDAO getPowerDAO(){
        return powerDAO;
    }
        
    
}
