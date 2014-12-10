package cz.muni.fi.pa165.hauntedhouses.service.services;

import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import java.util.List;

/**
 *
 * @author Michal Zbranek
 */
public interface GhostService {
    public void addGhost(GhostDTO ghostDTO);
    public void updateGhost(GhostDTO ghostDTO);
    public void deleteGhost(GhostDTO ghostDTO);
    public List<GhostDTO> getAllGhosts();
    public GhostDTO getGhostById(Long id);
}