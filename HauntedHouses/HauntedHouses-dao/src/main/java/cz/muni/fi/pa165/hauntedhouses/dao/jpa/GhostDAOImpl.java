package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Janicka
 */
public class GhostDAOImpl extends DAOBase implements GhostDAO{   
    
    @Override
    public void addGhost(Ghost ghost) {
        if (ghost == null) {
            throw new IllegalArgumentException("ghost is null");
        }
       try {
           getEntityManager().getTransaction().begin();
           getEntityManager().persist(ghost);
           getEntityManager().getTransaction().commit();     
       }
       catch(Exception e){
           throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);   
       }
    }

    @Override
    public void updateGhost(Ghost ghost) {
        if (ghost.getId() == null) {
            throw new IllegalArgumentException("Ghost id is null!");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(ghost);
            getEntityManager().getTransaction().commit();
        }
        catch (Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(),e);
        }
    }

    @Override
    public void deleteGhost(Ghost ghost) {
        try {
            getEntityManager().getTransaction().begin();
            Ghost toBeRemoved = getEntityManager().merge(ghost); 
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
                getEntityManager().getTransaction().commit();
            }
        }
        catch(Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public List<Ghost> getAllGhosts() {
        Query query = getEntityManager().createQuery("SELECT g FROM Ghost g");
        if(query==null){
            return new ArrayList<>();
        }
        else{
            return query.getResultList();
        }
    }

    @Override
    public Ghost getGhostById(Long id) {
        return getEntityManager().find(Ghost.class, id);       
    }
    
}
