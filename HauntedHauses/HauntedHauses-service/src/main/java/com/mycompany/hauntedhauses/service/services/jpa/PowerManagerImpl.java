package com.mycompany.hauntedhauses.service.services.jpa;

import org.dozer.DozerBeanMapper;
import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.entity.Power;
import com.mycompany.hauntedhauses.service.dto.PowerDTO;
import com.mycompany.hauntedhauses.service.services.PowerManager;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Jana Cechackova
 */
public class PowerManagerImpl implements PowerManager {
    
    PowerDAO powerDAO;
    DozerBeanMapper dozerBeanMapper;
    
    public void addPower(PowerDTO powerDTO) {
        Power power = null;

        try {
            if (powerDTO != null) {
                power = dozerBeanMapper.map(powerDTO, Power.class);
            }
            powerDAO.addPower(power);
        } catch (Exception ex) {
            throw new DataAccessException("Exception on persistence layer: " + ex.toString()) {
            };
        }
    }

    public void updatePower(PowerDTO powerDTO) {
        Power power = null;
        
        try{
        if (powerDTO != null) power = dozerBeanMapper.map(powerDTO, Power.class);
          powerDAO.updatePower(power);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    public void deletePower(PowerDTO powerDTO) {
        Power power = null;
        
        if (powerDTO != null) power = dozerBeanMapper.map(powerDTO, Power.class);
        try{
            powerDAO.deletePower(power);
        }catch(Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    public List<PowerDTO> getAllPowers() {
        List <PowerDTO> powersDTO = null;
        List <Power> powers = null;
        
        try{
            powers = powerDAO.getAllPowers();
            if (powers != null) powersDTO = dozerBeanMapper.map(powers, List.class);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
        return powersDTO;
    }

    public PowerDTO getPowerById(int id) {
        PowerDTO powerDTO = null;
        
        try{
            Power power = powerDAO.getPowerByID(id);
            if (power != null) powerDTO = dozerBeanMapper.map(power, PowerDTO.class);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
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
