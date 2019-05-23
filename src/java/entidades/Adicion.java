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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "adicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adicion.findAll", query = "SELECT a FROM Adicion a"),
    @NamedQuery(name = "Adicion.findByIdadicion", query = "SELECT a FROM Adicion a WHERE a.idadicion = :idadicion"),
    @NamedQuery(name = "Adicion.findByAdicionNombre", query = "SELECT a FROM Adicion a WHERE a.adicionNombre = :adicionNombre"),
    @NamedQuery(name = "Adicion.findByAdicionDescripcion", query = "SELECT a FROM Adicion a WHERE a.adicionDescripcion = :adicionDescripcion"),
    @NamedQuery(name = "Adicion.findByAdicionPrecio", query = "SELECT a FROM Adicion a WHERE a.adicionPrecio = :adicionPrecio")})
public class Adicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadicion")
    private Integer idadicion;
    @Size(max = 45)
    @Column(name = "adicion_nombre")
    private String adicionNombre;
    @Size(max = 45)
    @Column(name = "adicion_descripcion")
    private String adicionDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "adicion_precio")
    private Double adicionPrecio;

    public Adicion() {
    }

    public Adicion(Integer idadicion) {
        this.idadicion = idadicion;
    }

    public Integer getIdadicion() {
        return idadicion;
    }

    public void setIdadicion(Integer idadicion) {
        this.idadicion = idadicion;
    }

    public String getAdicionNombre() {
        return adicionNombre;
    }

    public void setAdicionNombre(String adicionNombre) {
        this.adicionNombre = adicionNombre;
    }

    public String getAdicionDescripcion() {
        return adicionDescripcion;
    }

    public void setAdicionDescripcion(String adicionDescripcion) {
        this.adicionDescripcion = adicionDescripcion;
    }

    public Double getAdicionPrecio() {
        return adicionPrecio;
    }

    public void setAdicionPrecio(Double adicionPrecio) {
        this.adicionPrecio = adicionPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadicion != null ? idadicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adicion)) {
            return false;
        }
        Adicion other = (Adicion) object;
        if ((this.idadicion == null && other.idadicion != null) || (this.idadicion != null && !this.idadicion.equals(other.idadicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Adicion[ idadicion=" + idadicion + " ]";
    }
    
}
