package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Michal Zbranek
 */
public interface GhostManager {
    public void addGhost(GhostDTO ghostDTO);
    public void updateGhost(GhostDTO ghostDTO);
    public void deleteGhost(GhostDTO ghostDTO);
    public List<GhostDTO> getAllGhosts();
    public GhostDTO getGhostById(Long id);
    public void setGhostDAO(GhostDAO ghostDAO);   
}