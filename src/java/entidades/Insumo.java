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
@Table(name = "insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByIdInsumo", query = "SELECT i FROM Insumo i WHERE i.idInsumo = :idInsumo"),
    @NamedQuery(name = "Insumo.findByInsumoNombre", query = "SELECT i FROM Insumo i WHERE i.insumoNombre = :insumoNombre"),
    @NamedQuery(name = "Insumo.findByInsumoDescripcion", query = "SELECT i FROM Insumo i WHERE i.insumoDescripcion = :insumoDescripcion"),
    @NamedQuery(name = "Insumo.findByInsumoPrecioCompra", query = "SELECT i FROM Insumo i WHERE i.insumoPrecioCompra = :insumoPrecioCompra"),
    @NamedQuery(name = "Insumo.findByInsumoPrecioDeVenta", query = "SELECT i FROM Insumo i WHERE i.insumoPrecioDeVenta = :insumoPrecioDeVenta"),
    @NamedQuery(name = "Insumo.findByInsumoCantidad", query = "SELECT i FROM Insumo i WHERE i.insumoCantidad = :insumoCantidad"),
    @NamedQuery(name = "Insumo.findByInsumoUniMedNombre", query = "SELECT i FROM Insumo i WHERE i.insumoUniMedNombre = :insumoUniMedNombre"),
    @NamedQuery(name = "Insumo.findByProFechaRegistro", query = "SELECT i FROM Insumo i WHERE i.proFechaRegistro = :proFechaRegistro"),
    @NamedQuery(name = "Insumo.findByProFechaVencimiento", query = "SELECT i FROM Insumo i WHERE i.proFechaVencimiento = :proFechaVencimiento"),
    @NamedQuery(name = "Insumo.findByIdProveedor", query = "SELECT i FROM Insumo i WHERE i.idProveedor = :idProveedor")})
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInsumo")
    private Integer idInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "insumo_nombre")
    private String insumoNombre;
    @Size(max = 45)
    @Column(name = "insumo_descripcion")
    private String insumoDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insumo_precio_compra")
    private double insumoPrecioCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "insumo_precio_de_venta")
    private Double insumoPrecioDeVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insumo_cantidad")
    private double insumoCantidad;
    @Size(max = 45)
    @Column(name = "insumo_uni_med_nombre")
    private String insumoUniMedNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pro_fecha_registro")
    private String proFechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pro_fecha_vencimiento")
    private String proFechaVencimiento;
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    public Insumo() {
    }

    public Insumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Insumo(Integer idInsumo, String insumoNombre, double insumoPrecioCompra, double insumoCantidad, String proFechaRegistro, String proFechaVencimiento) {
        this.idInsumo = idInsumo;
        this.insumoNombre = insumoNombre;
        this.insumoPrecioCompra = insumoPrecioCompra;
        this.insumoCantidad = insumoCantidad;
        this.proFechaRegistro = proFechaRegistro;
        this.proFechaVencimiento = proFechaVencimiento;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getInsumoNombre() {
        return insumoNombre;
    }

    public void setInsumoNombre(String insumoNombre) {
        this.insumoNombre = insumoNombre;
    }

    public String getInsumoDescripcion() {
        return insumoDescripcion;
    }

    public void setInsumoDescripcion(String insumoDescripcion) {
        this.insumoDescripcion = insumoDescripcion;
    }

    public double getInsumoPrecioCompra() {
        return insumoPrecioCompra;
    }

    public void setInsumoPrecioCompra(double insumoPrecioCompra) {
        this.insumoPrecioCompra = insumoPrecioCompra;
    }

    public Double getInsumoPrecioDeVenta() {
        return insumoPrecioDeVenta;
    }

    public void setInsumoPrecioDeVenta(Double insumoPrecioDeVenta) {
        this.insumoPrecioDeVenta = insumoPrecioDeVenta;
    }

    public double getInsumoCantidad() {
        return insumoCantidad;
    }

    public void setInsumoCantidad(double insumoCantidad) {
        this.insumoCantidad = insumoCantidad;
    }

    public String getInsumoUniMedNombre() {
        return insumoUniMedNombre;
    }

    public void setInsumoUniMedNombre(String insumoUniMedNombre) {
        this.insumoUniMedNombre = insumoUniMedNombre;
    }

    public String getProFechaRegistro() {
        return proFechaRegistro;
    }

    public void setProFechaRegistro(String proFechaRegistro) {
        this.proFechaRegistro = proFechaRegistro;
    }

    public String getProFechaVencimiento() {
        return proFechaVencimiento;
    }

    public void setProFechaVencimiento(String proFechaVencimiento) {
        this.proFechaVencimiento = proFechaVencimiento;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumo != null ? idInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.idInsumo == null && other.idInsumo != null) || (this.idInsumo != null && !this.idInsumo.equals(other.idInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Insumo[ idInsumo=" + idInsumo + " ]";
    }
    
}
