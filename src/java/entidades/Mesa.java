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
@Table(name = "mesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m"),
    @NamedQuery(name = "Mesa.findByIdMesa", query = "SELECT m FROM Mesa m WHERE m.idMesa = :idMesa"),
    @NamedQuery(name = "Mesa.findByNombre", query = "SELECT m FROM Mesa m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mesa.findByMesaPosicionX", query = "SELECT m FROM Mesa m WHERE m.mesaPosicionX = :mesaPosicionX"),
    @NamedQuery(name = "Mesa.findByMesaPosicionY", query = "SELECT m FROM Mesa m WHERE m.mesaPosicionY = :mesaPosicionY"),
    @NamedQuery(name = "Mesa.findByEstado", query = "SELECT m FROM Mesa m WHERE m.estado = :estado"),
    @NamedQuery(name = "Mesa.findByIdPedidoActual", query = "SELECT m FROM Mesa m WHERE m.idPedidoActual = :idPedidoActual")})
public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mesa")
    private Integer idMesa;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "mesaPosicionX")
    private Integer mesaPosicionX;
    @Column(name = "mesaPosicionY")
    private Integer mesaPosicionY;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 100)
    @Column(name = "idPedidoActual")
    private String idPedidoActual;

    public Mesa() {
    }

    public Mesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMesaPosicionX() {
        return mesaPosicionX;
    }

    public void setMesaPosicionX(Integer mesaPosicionX) {
        this.mesaPosicionX = mesaPosicionX;
    }

    public Integer getMesaPosicionY() {
        return mesaPosicionY;
    }

    public void setMesaPosicionY(Integer mesaPosicionY) {
        this.mesaPosicionY = mesaPosicionY;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdPedidoActual() {
        return idPedidoActual;
    }

    public void setIdPedidoActual(String idPedidoActual) {
        this.idPedidoActual = idPedidoActual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesa != null ? idMesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.idMesa == null && other.idMesa != null) || (this.idMesa != null && !this.idMesa.equals(other.idMesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mesa[ idMesa=" + idMesa + " ]";
    }
    
}
