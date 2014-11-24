package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import java.util.List;

/**
 *
 * @author Jana Cechackova
 */
public interface PowerManager {        
    public void addPower(PowerDTO powerDTO);
    public void updatePower(PowerDTO powerDTO);
    public void deletePower(PowerDTO powerDTO);
    public List<PowerDTO> getAllPowers();
    public PowerDTO getPowerById(Long id);
    public void setPowerDAO(PowerDAO powerDAO);    
}
