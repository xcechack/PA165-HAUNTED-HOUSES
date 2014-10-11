package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.entity.Resident;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentDAO {
    
   public void addResident(Resident resident);
   public void updateResident(Resident resident);
   public void deleteResident(Resident resident);
   public List<Resident> getAllResidents();
   public Resident getResidentByID(long id );
    
}
