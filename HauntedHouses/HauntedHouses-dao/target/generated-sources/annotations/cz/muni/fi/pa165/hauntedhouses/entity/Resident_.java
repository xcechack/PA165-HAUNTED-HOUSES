package cz.muni.fi.pa165.hauntedhouses.entity;

import cz.muni.fi.pa165.hauntedhouses.entity.House;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-24T16:47:28")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SingularAttribute<Resident, String> firstName;
    public static volatile SingularAttribute<Resident, String> lastName;
    public static volatile SingularAttribute<Resident, Long> id;
    public static volatile SingularAttribute<Resident, House> house;
    public static volatile SingularAttribute<Resident, Integer> age;

}