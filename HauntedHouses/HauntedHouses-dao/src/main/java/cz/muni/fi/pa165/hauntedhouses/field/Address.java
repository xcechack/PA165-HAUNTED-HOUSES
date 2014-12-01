package cz.muni.fi.pa165.hauntedhouses.field;

import javax.persistence.Embeddable;

/**
 *
 * @author Gabriela Poodlnikova
 */
@Embeddable
public class Address {
    
    private String street;
    private  int houseNumber;
    private String city;
    private int postalCode;

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the houseNumber
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = result*31 + street.hashCode();
        result = result*31 + houseNumber;
        result = result*31 + city.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Address other = (Address) obj;
        if (houseNumber != other.getHouseNumber() || !street.equals(other.street) || !city.equals(other.city) || postalCode != (other.postalCode)) {
            return false;
        }
        return true;
    }
    
}
