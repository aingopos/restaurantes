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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByFacCodigo", query = "SELECT f FROM Factura f WHERE f.facCodigo = :facCodigo"),
    @NamedQuery(name = "Factura.findByFacFecha", query = "SELECT f FROM Factura f WHERE f.facFecha = :facFecha"),
    @NamedQuery(name = "Factura.findByFacFormaPago", query = "SELECT f FROM Factura f WHERE f.facFormaPago = :facFormaPago"),
    @NamedQuery(name = "Factura.findByEmpleadoId", query = "SELECT f FROM Factura f WHERE f.empleadoId = :empleadoId"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByTax", query = "SELECT f FROM Factura f WHERE f.tax = :tax"),
    @NamedQuery(name = "Factura.findByGranTotal", query = "SELECT f FROM Factura f WHERE f.granTotal = :granTotal"),
    @NamedQuery(name = "Factura.findByMesaid", query = "SELECT f FROM Factura f WHERE f.mesaid = :mesaid"),
    @NamedQuery(name = "Factura.findByPedidoId", query = "SELECT f FROM Factura f WHERE f.pedidoId = :pedidoId")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "fac_codigo")
    private String facCodigo;
    @Size(max = 45)
    @Column(name = "fac_fecha")
    private String facFecha;
    @Size(max = 45)
    @Column(name = "fac_forma_pago")
    private String facFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "empleado id")
    private String empleadoId;
    @Size(max = 45)
    @Column(name = "total")
    private String total;
    @Size(max = 45)
    @Column(name = "tax")
    private String tax;
    @Size(max = 45)
    @Column(name = "granTotal")
    private String granTotal;
    @Size(max = 45)
    @Column(name = "mesaid")
    private String mesaid;
    @Size(max = 45)
    @Column(name = "pedidoId")
    private String pedidoId;

    public Factura() {
    }

    public Factura(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public Factura(String facCodigo, String empleadoId) {
        this.facCodigo = facCodigo;
        this.empleadoId = empleadoId;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public String getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(String facFecha) {
        this.facFecha = facFecha;
    }

    public String getFacFormaPago() {
        return facFormaPago;
    }

    public void setFacFormaPago(String facFormaPago) {
        this.facFormaPago = facFormaPago;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getGranTotal() {
        return granTotal;
    }

    public void setGranTotal(String granTotal) {
        this.granTotal = granTotal;
    }

    public String getMesaid() {
        return mesaid;
    }

    public void setMesaid(String mesaid) {
        this.mesaid = mesaid;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facCodigo != null ? facCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facCodigo == null && other.facCodigo != null) || (this.facCodigo != null && !this.facCodigo.equals(other.facCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Factura[ facCodigo=" + facCodigo + " ]";
    }
    
}
