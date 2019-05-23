/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ped_codigo")
    private int pedCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_codigo")
    private int facCodigo;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int pedCodigo, int facCodigo) {
        this.pedCodigo = pedCodigo;
        this.facCodigo = facCodigo;
    }

    public int getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(int pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public int getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(int facCodigo) {
        this.facCodigo = facCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedCodigo;
        hash += (int) facCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.pedCodigo != other.pedCodigo) {
            return false;
        }
        if (this.facCodigo != other.facCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleFacturaPK[ pedCodigo=" + pedCodigo + ", facCodigo=" + facCodigo + " ]";
    }
    
}
