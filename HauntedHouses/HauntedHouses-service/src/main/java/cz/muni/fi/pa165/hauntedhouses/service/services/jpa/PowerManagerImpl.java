package cz.muni.fi.pa165.hauntedhouses.service.services.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerManager;
import org.dozer.DozerBeanMapper;
import java.util.List;

/**
 *
 * @author Jana Cechackova
 */
public class PowerManagerImpl implements PowerManager {
    PowerDAO powerDAO;
    DozerBeanMapper dozerBeanMapper;
    
    public PowerManagerImpl(){
        dozerBeanMapper = new DozerBeanMapper();
    }
    
    @Override
    public void addPower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) {
            power = dozerBeanMapper.map(powerDTO, Power.class);
        }
        powerDAO.addPower(power);
    }
    
    @Override
    public void updatePower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) {
            power = dozerBeanMapper.map(powerDTO, Power.class);
        }
          powerDAO.updatePower(power);
    }

    @Override
    public void deletePower(PowerDTO powerDTO) {
        Power power = null;
        if (powerDTO != null) {
            power = dozerBeanMapper.map(powerDTO, Power.class);
        }
        powerDAO.deletePower(power);
    }

    @Override
    public List<PowerDTO> getAllPowers() {
        List <PowerDTO> powersDTO = null;
        List <Power> powers = powerDAO.getAllPowers();
        if (powers != null) {
            powersDTO = dozerBeanMapper.map(powers, List.class);
        }
        return powersDTO;
    }

    @Override
    public PowerDTO getPowerById(Long id) {
        PowerDTO powerDTO = null;
        Power power = powerDAO.getPowerById(id);
        if (power != null) {
            powerDTO = dozerBeanMapper.map(power, PowerDTO.class);
        }
        return powerDTO;
    }
    
    public void setPowerDAO(PowerDAO powerDAO){
        this.powerDAO = powerDAO;
    }
    
    public PowerDAO getPowerDAO(){
        return powerDAO;
    }
        
    
}
