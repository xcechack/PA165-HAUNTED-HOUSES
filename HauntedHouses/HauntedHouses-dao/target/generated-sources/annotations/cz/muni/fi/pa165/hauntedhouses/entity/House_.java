package cz.muni.fi.pa165.hauntedhouses.entity;

import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.field.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-30T20:30:30")
@StaticMetamodel(House.class)
public class House_ { 

    public static volatile SingularAttribute<House, Address> address;
    public static volatile ListAttribute<House, Ghost> ghosts;
    public static volatile SingularAttribute<House, String> name;
    public static volatile SingularAttribute<House, Date> hauntedFrom;
    public static volatile ListAttribute<House, Resident> residents;
    public static volatile SingularAttribute<House, Long> id;
    public static volatile SingularAttribute<House, String> history;

}