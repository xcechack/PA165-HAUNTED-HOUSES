package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.service.dto.HouseDTO;
import java.util.List;

/**
 *
 * @author Gabriela Podolnikova
 */
public interface HouseService {   
    public void addHouse(HouseDTO houseDTO);
    public void updateHouse(HouseDTO houseDTO);
    public void deleteHouse(HouseDTO houseDTO);
    public List<HouseDTO> getAllHouses();
    public HouseDTO getHouseById(Long id);
}
