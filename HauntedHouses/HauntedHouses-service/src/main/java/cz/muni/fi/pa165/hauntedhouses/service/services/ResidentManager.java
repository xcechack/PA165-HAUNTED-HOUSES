package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentManager {
    public void addResident(ResidentDTO residentDTO);
    public void updateResident(ResidentDTO residentDTO);
    public void deleteResident(ResidentDTO residentDTO);
    public List<ResidentDTO> getAllResidents();
    public ResidentDTO getResidentById(Long id);
    public void setResidentDAO(ResidentDAO residentDAO);
}
