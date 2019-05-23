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
@Table(name = "administradorSistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministradorSistema.findAll", query = "SELECT a FROM AdministradorSistema a"),
    @NamedQuery(name = "AdministradorSistema.findByIdAdmin", query = "SELECT a FROM AdministradorSistema a WHERE a.idAdmin = :idAdmin"),
    @NamedQuery(name = "AdministradorSistema.findByAdmCorreo", query = "SELECT a FROM AdministradorSistema a WHERE a.admCorreo = :admCorreo"),
    @NamedQuery(name = "AdministradorSistema.findByAdmClave", query = "SELECT a FROM AdministradorSistema a WHERE a.admClave = :admClave"),
    @NamedQuery(name = "AdministradorSistema.findByTipoAdmin", query = "SELECT a FROM AdministradorSistema a WHERE a.tipoAdmin = :tipoAdmin")})
public class AdministradorSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_correo")
    private String admCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_clave")
    private String admClave;
    @Size(max = 45)
    @Column(name = "tipo_Admin")
    private String tipoAdmin;

    public AdministradorSistema() {
    }

    public AdministradorSistema(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public AdministradorSistema(Integer idAdmin, String admCorreo, String admClave) {
        this.idAdmin = idAdmin;
        this.admCorreo = admCorreo;
        this.admClave = admClave;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getAdmCorreo() {
        return admCorreo;
    }

    public void setAdmCorreo(String admCorreo) {
        this.admCorreo = admCorreo;
    }

    public String getAdmClave() {
        return admClave;
    }

    public void setAdmClave(String admClave) {
        this.admClave = admClave;
    }

    public String getTipoAdmin() {
        return tipoAdmin;
    }

    public void setTipoAdmin(String tipoAdmin) {
        this.tipoAdmin = tipoAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministradorSistema)) {
            return false;
        }
        AdministradorSistema other = (AdministradorSistema) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AdministradorSistema[ idAdmin=" + idAdmin + " ]";
    }
    
}
