package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.ResidentDAO;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.dto.ResidentDTO;
import com.mycompany.hauntedhauses.service.services.ResidentManager;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Markéta Kružliaková
 */
public class ResidentManagerImpl implements ResidentManager {
   
    ResidentDAO residentDAO;
    DozerBeanMapper dozerBeanMapper;
    
    public ResidentManagerImpl(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Override
    public void addResident(ResidentDTO residentDTO) {
        
        Resident resident;
      
        if (residentDTO.getId() != null) {
            throw new IllegalArgumentException("Resident ID isn't null");
        } else {
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }
        try {
            residentDAO.addResident(resident);   
            residentDTO.setId(resident.getId());
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void updateResident(ResidentDTO residentDTO) {
        
        Resident resident;
        
        if (residentDTO.getId() == null) { 
            throw new IllegalArgumentException("Resident ID is null");
        } else {
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }
        try{
            residentDAO.updateResident(resident);
        
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void deleteResident(ResidentDTO residentDTO) {
        
        Resident resident;
        
        if (residentDTO == null) {
            throw new IllegalArgumentException("Resident ID is null.");
        }  
        else {
            resident = dozerBeanMapper.map(residentDTO, Resident.class);
        }     
        try {
            residentDAO.deleteResident(resident);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};                
        }    
    }

    @Override
    public List<ResidentDTO> getAllResidents() {
        
        List <ResidentDTO> residentsDTO = null;
        List <Resident> residents = null;
        
        try{
            residents = residentDAO.getAllResidents();             
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
        if (residents != null) {
            for (Resident resident : residents) {
                ResidentDTO residentDTO = dozerBeanMapper.map(resident, ResidentDTO.class);
                residentsDTO.add(residentDTO);
            }
        }
        return residentsDTO;
    }

    @Override
    public ResidentDTO getResidentByID(Long id) {
        
       Resident resident; 
       ResidentDTO residentDTO;
       
        try {
            if (id == null) {
                throw new IllegalArgumentException("Resident ID is null.");
            }
            else {
                resident = residentDAO.getResidentByID(id);
            }
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};                
        }
        residentDTO = dozerBeanMapper.map(resident, ResidentDTO.class); 
        return residentDTO;
    }
    
    
    @Inject
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper){
        this.dozerBeanMapper = dozerBeanMapper;
    }
    
    public DozerBeanMapper getDozerBeanMapper(){
        return dozerBeanMapper;
    }
    
    public void setResidentDAO(ResidentDAO residentDAO){
        this.residentDAO = residentDAO;
    }
    
    public ResidentDAO getResidentDAO(){
        return residentDAO;
    }
    
}
