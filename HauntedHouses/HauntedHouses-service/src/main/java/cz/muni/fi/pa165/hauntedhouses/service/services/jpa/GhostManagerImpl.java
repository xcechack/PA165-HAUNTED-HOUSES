package cz.muni.fi.pa165.hauntedhouses.service.services.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.GhostManager;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Michal Zbranek
 */
public class GhostManagerImpl implements GhostManager {
    @Autowired
    GhostDAO ghostDAO;
    @Autowired
    DozerBeanMapper dozerBeanMapper;
        
    @Override
    public void addGhost(GhostDTO ghostDTO) {
        Ghost ghost;
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
            ghostDAO.addGhost(ghost);
        ghostDTO.setId(ghost.getId());
    }

    @Override
    public void updateGhost(GhostDTO ghostDTO) {
        Ghost ghost;
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostDAO.updateGhost(ghost);       
    }

    @Override
    public void deleteGhost(GhostDTO ghostDTO) {
        Ghost ghost;
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        ghostDAO.deleteGhost(ghost);              
    }

    @Override
    public List<GhostDTO> getAllGhosts() {
        List <GhostDTO> ghostsDTO = null;
        List <Ghost> ghosts = null;
        ghosts = ghostDAO.getAllGhosts();             
        if (ghosts != null) {
            for (Ghost ghost : ghosts) {
                GhostDTO ghostDTO = dozerBeanMapper.map(ghost, GhostDTO.class);
                ghostsDTO.add(ghostDTO);
            }
        }
        return ghostsDTO;
    }

    @Override
    public GhostDTO getGhostById(Long id) {
       Ghost ghost;
       GhostDTO ghostDTO;
       ghost = ghostDAO.getGhostById(id);
       if (ghost == null) return null;
       ghostDTO = dozerBeanMapper.map(ghost, GhostDTO.class); 
       return ghostDTO;
    }
    
    public void setGhostDAO(GhostDAO ghostDAO){
        this.ghostDAO = ghostDAO;
    }
    
    public GhostDAO getGhostDAO(){
        return ghostDAO;
    }

    
}
