/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.PedidosMasVendidos;
import entidades.Plato;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "detallePedido")
public class DetallesPedidoPersistence {
    
    public boolean registrarDetallePedido(String idPedido, String idPlato, String precioProducto) {
        String str;
        try {
            str = "INSERT INTO `aingorestaurantes`.`detallePedido` (`idPlato`, `idPedido`, `precioProducto`) VALUES  ('" + idPlato + "', '" + idPedido + "','"+precioProducto+"');";
            Querys.executeQuery(str);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<PedidosMasVendidos> getPlatosDeUnPedido() {
        String str = "SELECT *, COUNT( idPlato ) AS total FROM  aingorestaurantes.detallePedido GROUP BY idPlato ORDER BY total DESC";
        List<PedidosMasVendidos> platos = new ArrayList<>();
        try {
            Connection conexion = null;
            ConexionSQL sql = new ConexionSQL();
            conexion = sql.getConexion();
            Statement st = (Statement) conexion.createStatement();
            st.execute(str);
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                PedidosMasVendidos plato = new PedidosMasVendidos();
                plato.setNombre((String) rs.getObject("idPlato"));
                plato.setPrecio(rs.getString("precioProducto")); 
                plato.setCantidadApariciones(rs.getString("total"));
                platos.add(plato);

            }
            rs.close();
            
        } catch (Exception e) {
            System.out.println("no se logro la conexion");
        }
        return platos;
    }
    
}
