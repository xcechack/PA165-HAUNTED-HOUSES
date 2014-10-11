/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.entity;

/**
 *
 * @author Gabriela Poodlnikova
 */
public class Address {
    
    private final String street;
    private final  int houseNumber;
    private final String city;
    private final int postalCode;
    
    public Address(String street, int houseNumber, String city, int postalCode) {
        this.street=street;
        this.houseNumber=houseNumber;
        this.city=city;
        this.postalCode=postalCode;
    }
}
