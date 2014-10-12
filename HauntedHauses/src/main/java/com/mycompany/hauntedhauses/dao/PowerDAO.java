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
   public void addPower(Power power);
   public void updatePower(Power power);
   public void deletePower(Power power);
   public List<Power> getAllPowers();
   public Power getPowerByID(long id );
}
