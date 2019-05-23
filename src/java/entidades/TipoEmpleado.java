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
@Table(name = "tipoEmpleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmpleado.findAll", query = "SELECT t FROM TipoEmpleado t"),
    @NamedQuery(name = "TipoEmpleado.findById", query = "SELECT t FROM TipoEmpleado t WHERE t.id = :id"),
    @NamedQuery(name = "TipoEmpleado.findByTipoEmpleadoDescripcion", query = "SELECT t FROM TipoEmpleado t WHERE t.tipoEmpleadoDescripcion = :tipoEmpleadoDescripcion")})
public class TipoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tipo_empleado_descripcion")
    private String tipoEmpleadoDescripcion;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEmpleadoDescripcion() {
        return tipoEmpleadoDescripcion;
    }

    public void setTipoEmpleadoDescripcion(String tipoEmpleadoDescripcion) {
        this.tipoEmpleadoDescripcion = tipoEmpleadoDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpleado)) {
            return false;
        }
        TipoEmpleado other = (TipoEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoEmpleado[ id=" + id + " ]";
    }
    
}
