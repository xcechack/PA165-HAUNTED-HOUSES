/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao;

import com.mycompany.hauntedhauses.service.Ghost;
import java.util.List;

/**
 *
 * @author Jana Cechackova
 */
public interface GhostDAO {
    public void addGhost(Ghost ghost);
    public void updateGhost(Ghost ghost);
    public void deleteGhost(Ghost ghost);
    public List<Ghost> getAllGhosts();
    public Ghost getGhostByID(long id);
}
