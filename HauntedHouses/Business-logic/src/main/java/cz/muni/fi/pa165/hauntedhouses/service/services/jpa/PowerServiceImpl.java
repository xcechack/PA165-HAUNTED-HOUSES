package cz.muni.fi.pa165.hauntedhouses.service.services.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerService;
import java.util.ArrayList;
import org.dozer.DozerBeanMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jana Cechackova
 */
public class PowerServiceImpl implements PowerService {
    
    @Autowired
    PowerDAO powerDAO;
    
    @Autowired
    DozerBeanMapper dozerBeanMapper;
        
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
        if (powers.size() != 0) {
            powersDTO = dozerBeanMapper.map(powers, List.class);
        } else powersDTO = new ArrayList<PowerDTO>();
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
