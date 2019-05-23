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
import javax.persistence.Lob;
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
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByPlaNombre", query = "SELECT p FROM Plato p WHERE p.plaNombre = :plaNombre"),
    @NamedQuery(name = "Plato.findByPlaPrecioVenta", query = "SELECT p FROM Plato p WHERE p.plaPrecioVenta = :plaPrecioVenta"),
    @NamedQuery(name = "Plato.findByPlaDescuento", query = "SELECT p FROM Plato p WHERE p.plaDescuento = :plaDescuento"),
    @NamedQuery(name = "Plato.findByPlaTipo", query = "SELECT p FROM Plato p WHERE p.plaTipo = :plaTipo"),
    @NamedQuery(name = "Plato.findByPlaCantidadPersonas", query = "SELECT p FROM Plato p WHERE p.plaCantidadPersonas = :plaCantidadPersonas")})
public class Plato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pla_nombre")
    private String plaNombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pla_descripcion")
    private String plaDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_precio_venta")
    private int plaPrecioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_descuento")
    private int plaDescuento;
    @Column(name = "pla_tipo")
    private Integer plaTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_cantidad_personas")
    private int plaCantidadPersonas;
    @Lob
    @Size(max = 65535)
    @Column(name = "pla_foto")
    private String plaFoto;

    public Plato() {
    }

    public Plato(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    public Plato(String plaNombre, String plaDescripcion, int plaPrecioVenta, int plaDescuento, int plaCantidadPersonas) {
        this.plaNombre = plaNombre;
        this.plaDescripcion = plaDescripcion;
        this.plaPrecioVenta = plaPrecioVenta;
        this.plaDescuento = plaDescuento;
        this.plaCantidadPersonas = plaCantidadPersonas;
    }

    public String getPlaNombre() {
        return plaNombre;
    }

    public void setPlaNombre(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    public String getPlaDescripcion() {
        return plaDescripcion;
    }

    public void setPlaDescripcion(String plaDescripcion) {
        this.plaDescripcion = plaDescripcion;
    }

    public int getPlaPrecioVenta() {
        return plaPrecioVenta;
    }

    public void setPlaPrecioVenta(int plaPrecioVenta) {
        this.plaPrecioVenta = plaPrecioVenta;
    }

    public int getPlaDescuento() {
        return plaDescuento;
    }

    public void setPlaDescuento(int plaDescuento) {
        this.plaDescuento = plaDescuento;
    }

    public Integer getPlaTipo() {
        return plaTipo;
    }

    public void setPlaTipo(Integer plaTipo) {
        this.plaTipo = plaTipo;
    }

    public int getPlaCantidadPersonas() {
        return plaCantidadPersonas;
    }

    public void setPlaCantidadPersonas(int plaCantidadPersonas) {
        this.plaCantidadPersonas = plaCantidadPersonas;
    }

    public String getPlaFoto() {
        return plaFoto;
    }

    public void setPlaFoto(String plaFoto) {
        this.plaFoto = plaFoto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaNombre != null ? plaNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.plaNombre == null && other.plaNombre != null) || (this.plaNombre != null && !this.plaNombre.equals(other.plaNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Plato[ plaNombre=" + plaNombre + " ]";
    }
    
}
