/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.ResidentDAO;
import com.mycompany.hauntedhauses.entity.Resident;
import com.mycompany.hauntedhauses.service.dto.ResidentDTO;
import com.mycompany.hauntedhauses.service.services.ResidentManager;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Markéta Kružliaková
 */
public class ResidentManagerImpl implements ResidentManager {
   
    ResidentDAO residentDAO;
    DozerBeanMapper dozerBeanMapper;

    public void addResident(ResidentDTO residentDTO) {
        
        if (residentDTO != null) {
            Resident resident = dozerBeanMapper.map(residentDTO, Resident.class);
            residentDAO.addResident(resident);
        } else {
        //TODO
        } 
    }

    public void updateResident(ResidentDTO residentDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteResident(ResidentDTO residentDTO) {
        if (residentDTO == null) {
            throw new IllegalArgumentException("Resident is null.");
        }
        else {
            Resident resident = dozerBeanMapper.map(residentDTO, Resident.class);
            residentDAO.deleteResident(resident);
        }
    }

    public List<ResidentDTO> getAllResidents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResidentDTO getResidentByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
