/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao;

import com.mycompany.hauntedhauses.entity.Power;
import java.util.List;

/**
 *
 * @author Michal Zbranek
 */
public interface PowerDAO {
   public boolean addPower(Power power);
   public boolean updatePower(Power power);
   public boolean deletePower(Power power);
   public List<Power> getAllPowers();
   public Power getPowerByID(long id );
}
