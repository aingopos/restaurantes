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
@Table(name = "tipoAdmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAdmin.findAll", query = "SELECT t FROM TipoAdmin t"),
    @NamedQuery(name = "TipoAdmin.findByIdTipoAdmin", query = "SELECT t FROM TipoAdmin t WHERE t.idTipoAdmin = :idTipoAdmin"),
    @NamedQuery(name = "TipoAdmin.findByTipoAdminDescripcion", query = "SELECT t FROM TipoAdmin t WHERE t.tipoAdminDescripcion = :tipoAdminDescripcion"),
    @NamedQuery(name = "TipoAdmin.findById", query = "SELECT t FROM TipoAdmin t WHERE t.id = :id")})
public class TipoAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_admin")
    private Integer idTipoAdmin;
    @Size(max = 45)
    @Column(name = "tipo_admin_descripcion")
    private String tipoAdminDescripcion;
    @Size(max = 45)
    @Column(name = "id")
    private String id;

    public TipoAdmin() {
    }

    public TipoAdmin(Integer idTipoAdmin) {
        this.idTipoAdmin = idTipoAdmin;
    }

    public Integer getIdTipoAdmin() {
        return idTipoAdmin;
    }

    public void setIdTipoAdmin(Integer idTipoAdmin) {
        this.idTipoAdmin = idTipoAdmin;
    }

    public String getTipoAdminDescripcion() {
        return tipoAdminDescripcion;
    }

    public void setTipoAdminDescripcion(String tipoAdminDescripcion) {
        this.tipoAdminDescripcion = tipoAdminDescripcion;
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
        hash += (idTipoAdmin != null ? idTipoAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAdmin)) {
            return false;
        }
        TipoAdmin other = (TipoAdmin) object;
        if ((this.idTipoAdmin == null && other.idTipoAdmin != null) || (this.idTipoAdmin != null && !this.idTipoAdmin.equals(other.idTipoAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoAdmin[ idTipoAdmin=" + idTipoAdmin + " ]";
    }
    
}
