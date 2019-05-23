/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByPedCodigo", query = "SELECT p FROM Pedido p WHERE p.pedCodigo = :pedCodigo"),
    @NamedQuery(name = "Pedido.findByMeseroId", query = "SELECT p FROM Pedido p WHERE p.meseroId = :meseroId"),
    @NamedQuery(name = "Pedido.findByPedidoFecha", query = "SELECT p FROM Pedido p WHERE p.pedidoFecha = :pedidoFecha"),
    @NamedQuery(name = "Pedido.findByPedidoHoraInicio", query = "SELECT p FROM Pedido p WHERE p.pedidoHoraInicio = :pedidoHoraInicio"),
    @NamedQuery(name = "Pedido.findByPedidoTotal", query = "SELECT p FROM Pedido p WHERE p.pedidoTotal = :pedidoTotal"),
    @NamedQuery(name = "Pedido.findByPedidoMesa", query = "SELECT p FROM Pedido p WHERE p.pedidoMesa = :pedidoMesa")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ped_codigo")
    private String pedCodigo;
    @Column(name = "mesero_id")
    private Integer meseroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pedido_fecha")
    private String pedidoFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pedido_hora_inicio")
    private String pedidoHoraInicio;
    @Size(max = 100)
    @Column(name = "pedido_total")
    private String pedidoTotal;
    @Size(max = 45)
    @Column(name = "pedido_mesa")
    private String pedidoMesa;

    public Pedido() {
    }

    public Pedido(String pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public Pedido(String pedCodigo, String pedidoFecha, String pedidoHoraInicio) {
        this.pedCodigo = pedCodigo;
        this.pedidoFecha = pedidoFecha;
        this.pedidoHoraInicio = pedidoHoraInicio;
    }

    public String getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(String pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public Integer getMeseroId() {
        return meseroId;
    }

    public void setMeseroId(Integer meseroId) {
        this.meseroId = meseroId;
    }

    public String getPedidoFecha() {
        return pedidoFecha;
    }

    public void setPedidoFecha(String pedidoFecha) {
        this.pedidoFecha = pedidoFecha;
    }

    public String getPedidoHoraInicio() {
        return pedidoHoraInicio;
    }

    public void setPedidoHoraInicio(String pedidoHoraInicio) {
        this.pedidoHoraInicio = pedidoHoraInicio;
    }

    public String getPedidoTotal() {
        return pedidoTotal;
    }

    public void setPedidoTotal(String pedidoTotal) {
        this.pedidoTotal = pedidoTotal;
    }

    public String getPedidoMesa() {
        return pedidoMesa;
    }

    public void setPedidoMesa(String pedidoMesa) {
        this.pedidoMesa = pedidoMesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedCodigo != null ? pedCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedCodigo == null && other.pedCodigo != null) || (this.pedCodigo != null && !this.pedCodigo.equals(other.pedCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedido[ pedCodigo=" + pedCodigo + " ]";
    }
    
}
