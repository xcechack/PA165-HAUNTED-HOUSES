package cz.muni.fi.pa165.hauntedhouses.entity;

import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-01T18:30:46")
@StaticMetamodel(Ghost.class)
public class Ghost_ { 

    public static volatile SingularAttribute<Ghost, Timestamp> scaryTimeEnd;
    public static volatile SingularAttribute<Ghost, String> name;
    public static volatile SingularAttribute<Ghost, Long> id;
    public static volatile SingularAttribute<Ghost, Power> power;
    public static volatile SingularAttribute<Ghost, House> house;
    public static volatile SingularAttribute<Ghost, Timestamp> scaryTimeStart;
    public static volatile SingularAttribute<Ghost, String> info;

}