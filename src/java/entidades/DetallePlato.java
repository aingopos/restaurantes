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
@Table(name = "detallePlato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePlato.findAll", query = "SELECT d FROM DetallePlato d"),
    @NamedQuery(name = "DetallePlato.findByProCodigo", query = "SELECT d FROM DetallePlato d WHERE d.proCodigo = :proCodigo"),
    @NamedQuery(name = "DetallePlato.findByPlaNombre", query = "SELECT d FROM DetallePlato d WHERE d.plaNombre = :plaNombre"),
    @NamedQuery(name = "DetallePlato.findByDetPlaCantidadProductos", query = "SELECT d FROM DetallePlato d WHERE d.detPlaCantidadProductos = :detPlaCantidadProductos"),
    @NamedQuery(name = "DetallePlato.findById", query = "SELECT d FROM DetallePlato d WHERE d.id = :id")})
public class DetallePlato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    @Size(max = 45)
    @Column(name = "pla_nombre")
    private String plaNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "det_pla_cantidad_productos")
    private Double detPlaCantidadProductos;
    @Size(max = 45)
    @Column(name = "id")
    private String id;

    public DetallePlato() {
    }

    public DetallePlato(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getPlaNombre() {
        return plaNombre;
    }

    public void setPlaNombre(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    public Double getDetPlaCantidadProductos() {
        return detPlaCantidadProductos;
    }

    public void setDetPlaCantidadProductos(Double detPlaCantidadProductos) {
        this.detPlaCantidadProductos = detPlaCantidadProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePlato)) {
            return false;
        }
        DetallePlato other = (DetallePlato) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetallePlato[ proCodigo=" + proCodigo + " ]";
    }
    
}
