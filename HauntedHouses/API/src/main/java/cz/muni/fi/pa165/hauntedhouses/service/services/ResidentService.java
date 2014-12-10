package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentService {
    public void addResident(ResidentDTO residentDTO);
    public void updateResident(ResidentDTO residentDTO);
    public void deleteResident(ResidentDTO residentDTO);
    public List<ResidentDTO> getAllResidents();
    public ResidentDTO getResidentById(Long id);
}
