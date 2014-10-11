/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseManagerImpl implements HouseManager{
    
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/houses.odb");
    private EntityManager em = emf.createEntityManager();
    
    public void addHouse(){
        
    }
    
    public void deleteHouse() {
        
    }
    
    public List<House> listOfHouses() {
        return null;
    }
}
