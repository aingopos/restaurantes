package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T19:47:44")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Date> detResHoraInicio;
    public static volatile SingularAttribute<Reserva, Integer> resCodigo;
    public static volatile SingularAttribute<Reserva, String> reservaIdCliente;
    public static volatile SingularAttribute<Reserva, Date> detResHoraFin;
    public static volatile SingularAttribute<Reserva, Date> detResFecha;

}