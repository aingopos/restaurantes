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
@Table(name = "unidadMedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByIdUnidadMEdida", query = "SELECT u FROM UnidadMedida u WHERE u.idUnidadMEdida = :idUnidadMEdida"),
    @NamedQuery(name = "UnidadMedida.findByNombre", query = "SELECT u FROM UnidadMedida u WHERE u.nombre = :nombre")})
public class UnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUnidadMEdida")
    private Integer idUnidadMEdida;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idUnidadMEdida) {
        this.idUnidadMEdida = idUnidadMEdida;
    }

    public Integer getIdUnidadMEdida() {
        return idUnidadMEdida;
    }

    public void setIdUnidadMEdida(Integer idUnidadMEdida) {
        this.idUnidadMEdida = idUnidadMEdida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMEdida != null ? idUnidadMEdida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnidadMEdida == null && other.idUnidadMEdida != null) || (this.idUnidadMEdida != null && !this.idUnidadMEdida.equals(other.idUnidadMEdida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UnidadMedida[ idUnidadMEdida=" + idUnidadMEdida + " ]";
    }
    
}
