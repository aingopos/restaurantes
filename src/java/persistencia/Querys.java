package persistencia;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import persistencia.ConexionSQL;

public class Querys {

    public static final void executeQuery(String Query){
        try {
            Connection conexion = null;
            ConexionSQL sql = new ConexionSQL();
            conexion = sql.getConexion();
            Statement st = null;
            st = (Statement) conexion.createStatement();
            st.execute(Query);
            System.out.println("Query success");
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting");
        }
/*SELECT *, COUNT( idPlato ) AS total FROM  aingorestaurantes.detallePedido GROUP BY idPlato ORDER BY total DESC

SELECT * FROM aingorestaurantes.detallePedido WHERE `idPedido`='2019-05-19-25:4:124';

INSERT INTO `aingorestaurantes`.`detallePedido` (`id`, `idPlato`, `idPedido`, `precioProducto`) VALUES ('136', 'pizza', '2019-05-20-06:56:41', '12000');



*/

    }

}
