/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.entity.Ghost;
import java.util.List;

/**
 *
 * @author Jana Cechackova
 */
public interface GhostDAO {
    public boolean addGhost(Ghost ghost);
    public boolean updateGhost(Ghost ghost);
    public boolean deleteGhost(Ghost ghost);
    public List<Ghost> getAllGhosts();
    public Ghost getGhostByID(long id);
}
