package cz.muni.fi.pa165.hauntedhouses.service.services.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.ResidentManager;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Markéta Kružliaková
 */
public class ResidentManagerImpl implements ResidentManager {
    ResidentDAO residentDAO;
    DozerBeanMapper dozerBeanMapper;
    
    public ResidentManagerImpl() {
        this.dozerBeanMapper = new DozerBeanMapper();
    }

    @Override
    public void addResident(ResidentDTO residentDTO) {
        Resident resident = null;
        if (residentDTO != null){
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }
        residentDAO.addResident(resident);   
    }

    @Override
    public void updateResident(ResidentDTO residentDTO) {
        Resident resident = null;
        if (residentDTO != null){
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }
        residentDAO.updateResident(resident);
    }

    @Override
    public void deleteResident(ResidentDTO residentDTO) {
        Resident resident = null;
        if (residentDTO != null){
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }
        residentDAO.deleteResident(resident);
    }

    @Override
    public List<ResidentDTO> getAllResidents() {
        List <ResidentDTO> residentsDTO = null;
        List <Resident> residents = residentDAO.getAllResidents();  
        if (residents != null) {
                residentsDTO = dozerBeanMapper.map(residents, List.class);
        }
        return residentsDTO;
    }

    @Override
    public ResidentDTO getResidentById(Long id) {
        ResidentDTO residentDTO = null;
        Resident resident = residentDAO.getResidentById(id); 
        if (resident != null) {
                residentDTO = dozerBeanMapper.map(resident, ResidentDTO.class); 
        }
        return residentDTO;
    }        
        
    public void setResidentDAO(ResidentDAO residentDAO){
        this.residentDAO = residentDAO;
    }
    
    public ResidentDAO getResidentDAO(){
        return residentDAO;
    }
}
