/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

import java.util.List;

/**
 *
 * @author Gabriela Podolnikova
 */
public interface HouseManager {
    
    public void addHouse();
    
    public void deleteHouse();
    
    public List<House> listOfHouses();
}
