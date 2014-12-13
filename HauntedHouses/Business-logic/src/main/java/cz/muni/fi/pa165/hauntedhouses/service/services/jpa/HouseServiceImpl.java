package cz.muni.fi.pa165.hauntedhouses.service.services.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.service.dto.HouseDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.HouseService;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseDAO houseDAO;
    @Autowired
    DozerBeanMapper dozerBeanMapper;
    
    @Override
    public void addHouse(HouseDTO houseDTO) {
        House house = null;
        if(houseDTO != null){
            house = dozerBeanMapper.map(houseDTO, House.class);
        }
        houseDAO.addHouse(house);    
    }

    @Override
    public void updateHouse(HouseDTO houseDTO) {
        House house = null;
        if (houseDTO != null){
            house = dozerBeanMapper.map(houseDTO, House.class);
        }
        houseDAO.updateHouse(house);
    }

    @Override
    public void deleteHouse(HouseDTO houseDTO) {
    House house = null;
        if (houseDTO != null) {
            house = dozerBeanMapper.map(houseDTO, House.class);
        }  
        houseDAO.deleteHouse(house);
    }

    @Override
    public List<HouseDTO> getAllHouses() {
        List <HouseDTO> housesDTO = null;
        List <House> houses = houseDAO.getAllHouses();           
        housesDTO = dozerBeanMapper.map(houses, List.class);
        return housesDTO;
    }

    @Override
    public HouseDTO getHouseById(Long id) {
        HouseDTO houseDTO = null;
        House house = houseDAO.getHouseById(id);               
        if (house != null) {
            houseDTO = dozerBeanMapper.map(house, HouseDTO.class); 
        }
        return houseDTO;
    }
    
}
