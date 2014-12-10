package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Janicka
 */
public class GhostDAOImpl extends DAOBase implements GhostDAO{   
    
    @Override
    @Transactional
    public void addGhost(Ghost ghost) {
        if (ghost == null) {
            throw new IllegalArgumentException("ghost is null");
        }
       try {
           getEntityManager().persist(ghost);     
       }
       catch(Exception e){
           throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);   
       }
    }

    @Override
    @Transactional
    public void updateGhost(Ghost ghost) {
        if (ghost.getId() == null) {
            throw new IllegalArgumentException("Ghost id is null!");
        }
        try {
            getEntityManager().merge(ghost);
        }
        catch (Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(),e);
        }
    }

    @Override
    @Transactional
    public void deleteGhost(Ghost ghost) {
        try {
            Ghost toBeRemoved = getEntityManager().merge(ghost); 
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        }
        catch(Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public List<Ghost> getAllGhosts() {
        Query query = getEntityManager().createQuery("SELECT g FROM Ghost g");
        List<Ghost> result;
        if((result = query.getResultList())==null){
            return new ArrayList<Ghost>();
        }
        else{
            return result;
        }
    }

    @Override
    @Transactional
    public Ghost getGhostById(Long id) {
        return getEntityManager().find(Ghost.class, id);       
    }
    
}
