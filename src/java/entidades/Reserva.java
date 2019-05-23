/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByDetResFecha", query = "SELECT r FROM Reserva r WHERE r.detResFecha = :detResFecha"),
    @NamedQuery(name = "Reserva.findByDetResHoraInicio", query = "SELECT r FROM Reserva r WHERE r.detResHoraInicio = :detResHoraInicio"),
    @NamedQuery(name = "Reserva.findByDetResHoraFin", query = "SELECT r FROM Reserva r WHERE r.detResHoraFin = :detResHoraFin"),
    @NamedQuery(name = "Reserva.findByResCodigo", query = "SELECT r FROM Reserva r WHERE r.resCodigo = :resCodigo"),
    @NamedQuery(name = "Reserva.findByReservaIdCliente", query = "SELECT r FROM Reserva r WHERE r.reservaIdCliente = :reservaIdCliente")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_res_fecha")
    @Temporal(TemporalType.DATE)
    private Date detResFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_res_hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date detResHoraInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_res_hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date detResHoraFin;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_codigo")
    private Integer resCodigo;
    @Size(max = 45)
    @Column(name = "reserva_id_cliente")
    private String reservaIdCliente;

    public Reserva() {
    }

    public Reserva(Integer resCodigo) {
        this.resCodigo = resCodigo;
    }

    public Reserva(Integer resCodigo, Date detResFecha, Date detResHoraInicio, Date detResHoraFin) {
        this.resCodigo = resCodigo;
        this.detResFecha = detResFecha;
        this.detResHoraInicio = detResHoraInicio;
        this.detResHoraFin = detResHoraFin;
    }

    public Date getDetResFecha() {
        return detResFecha;
    }

    public void setDetResFecha(Date detResFecha) {
        this.detResFecha = detResFecha;
    }

    public Date getDetResHoraInicio() {
        return detResHoraInicio;
    }

    public void setDetResHoraInicio(Date detResHoraInicio) {
        this.detResHoraInicio = detResHoraInicio;
    }

    public Date getDetResHoraFin() {
        return detResHoraFin;
    }

    public void setDetResHoraFin(Date detResHoraFin) {
        this.detResHoraFin = detResHoraFin;
    }

    public Integer getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Integer resCodigo) {
        this.resCodigo = resCodigo;
    }

    public String getReservaIdCliente() {
        return reservaIdCliente;
    }

    public void setReservaIdCliente(String reservaIdCliente) {
        this.reservaIdCliente = reservaIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resCodigo != null ? resCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.resCodigo == null && other.resCodigo != null) || (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reserva[ resCodigo=" + resCodigo + " ]";
    }
    
}
