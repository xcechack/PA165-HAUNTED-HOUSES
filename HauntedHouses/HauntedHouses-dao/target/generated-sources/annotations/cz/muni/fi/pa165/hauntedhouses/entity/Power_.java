package cz.muni.fi.pa165.hauntedhouses.entity;

import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-01T14:56:24")
@StaticMetamodel(Power.class)
public class Power_ { 

    public static volatile ListAttribute<Power, Ghost> ghosts;
    public static volatile SingularAttribute<Power, String> name;
    public static volatile SingularAttribute<Power, String> description;
    public static volatile SingularAttribute<Power, Long> id;

}