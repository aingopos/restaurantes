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
@Table(name = "tipoPlato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlato.findAll", query = "SELECT t FROM TipoPlato t"),
    @NamedQuery(name = "TipoPlato.findByIdTipoPlato", query = "SELECT t FROM TipoPlato t WHERE t.idTipoPlato = :idTipoPlato"),
    @NamedQuery(name = "TipoPlato.findByTipoPlatoDescripcion", query = "SELECT t FROM TipoPlato t WHERE t.tipoPlatoDescripcion = :tipoPlatoDescripcion")})
public class TipoPlato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_plato")
    private Integer idTipoPlato;
    @Size(max = 45)
    @Column(name = "tipo_plato_descripcion")
    private String tipoPlatoDescripcion;

    public TipoPlato() {
    }

    public TipoPlato(Integer idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }

    public Integer getIdTipoPlato() {
        return idTipoPlato;
    }

    public void setIdTipoPlato(Integer idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }

    public String getTipoPlatoDescripcion() {
        return tipoPlatoDescripcion;
    }

    public void setTipoPlatoDescripcion(String tipoPlatoDescripcion) {
        this.tipoPlatoDescripcion = tipoPlatoDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPlato != null ? idTipoPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlato)) {
            return false;
        }
        TipoPlato other = (TipoPlato) object;
        if ((this.idTipoPlato == null && other.idTipoPlato != null) || (this.idTipoPlato != null && !this.idTipoPlato.equals(other.idTipoPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoPlato[ idTipoPlato=" + idTipoPlato + " ]";
    }
    
}
