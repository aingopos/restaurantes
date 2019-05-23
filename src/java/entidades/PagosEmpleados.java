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
@Table(name = "pagosEmpleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagosEmpleados.findAll", query = "SELECT p FROM PagosEmpleados p"),
    @NamedQuery(name = "PagosEmpleados.findByIdpagosEmpleados", query = "SELECT p FROM PagosEmpleados p WHERE p.idpagosEmpleados = :idpagosEmpleados"),
    @NamedQuery(name = "PagosEmpleados.findByEmpleadoId", query = "SELECT p FROM PagosEmpleados p WHERE p.empleadoId = :empleadoId"),
    @NamedQuery(name = "PagosEmpleados.findByPagoValorTotal", query = "SELECT p FROM PagosEmpleados p WHERE p.pagoValorTotal = :pagoValorTotal"),
    @NamedQuery(name = "PagosEmpleados.findByFechaDePago", query = "SELECT p FROM PagosEmpleados p WHERE p.fechaDePago = :fechaDePago"),
    @NamedQuery(name = "PagosEmpleados.findByHorasTrabajadas", query = "SELECT p FROM PagosEmpleados p WHERE p.horasTrabajadas = :horasTrabajadas"),
    @NamedQuery(name = "PagosEmpleados.findByHorasExtra", query = "SELECT p FROM PagosEmpleados p WHERE p.horasExtra = :horasExtra"),
    @NamedQuery(name = "PagosEmpleados.findByHorasDominicales", query = "SELECT p FROM PagosEmpleados p WHERE p.horasDominicales = :horasDominicales"),
    @NamedQuery(name = "PagosEmpleados.findByHorasExtraDominicales", query = "SELECT p FROM PagosEmpleados p WHERE p.horasExtraDominicales = :horasExtraDominicales"),
    @NamedQuery(name = "PagosEmpleados.findByHorasNocturnas", query = "SELECT p FROM PagosEmpleados p WHERE p.horasNocturnas = :horasNocturnas"),
    @NamedQuery(name = "PagosEmpleados.findByHorasExtraNocturnas", query = "SELECT p FROM PagosEmpleados p WHERE p.horasExtraNocturnas = :horasExtraNocturnas"),
    @NamedQuery(name = "PagosEmpleados.findByHorasExtraDomiNoc", query = "SELECT p FROM PagosEmpleados p WHERE p.horasExtraDomiNoc = :horasExtraDomiNoc"),
    @NamedQuery(name = "PagosEmpleados.findBySubsidioTransporte", query = "SELECT p FROM PagosEmpleados p WHERE p.subsidioTransporte = :subsidioTransporte"),
    @NamedQuery(name = "PagosEmpleados.findBySubsidioSalud", query = "SELECT p FROM PagosEmpleados p WHERE p.subsidioSalud = :subsidioSalud")})
public class PagosEmpleados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpagosEmpleados")
    private Integer idpagosEmpleados;
    @Size(max = 45)
    @Column(name = "empleado_id")
    private String empleadoId;
    @Size(max = 45)
    @Column(name = "pago_valor_total")
    private String pagoValorTotal;
    @Size(max = 45)
    @Column(name = "fecha_de_pago")
    private String fechaDePago;
    @Size(max = 45)
    @Column(name = "horas_trabajadas")
    private String horasTrabajadas;
    @Size(max = 45)
    @Column(name = "horas_extra")
    private String horasExtra;
    @Size(max = 45)
    @Column(name = "horas_dominicales")
    private String horasDominicales;
    @Size(max = 45)
    @Column(name = "horas_extra_dominicales")
    private String horasExtraDominicales;
    @Size(max = 45)
    @Column(name = "horas_nocturnas")
    private String horasNocturnas;
    @Size(max = 45)
    @Column(name = "horas_extra_nocturnas")
    private String horasExtraNocturnas;
    @Size(max = 45)
    @Column(name = "horas_extra_domi_noc")
    private String horasExtraDomiNoc;
    @Size(max = 45)
    @Column(name = "subsidio_transporte")
    private String subsidioTransporte;
    @Size(max = 45)
    @Column(name = "subsidio_salud")
    private String subsidioSalud;

    public PagosEmpleados() {
    }

    public PagosEmpleados(Integer idpagosEmpleados) {
        this.idpagosEmpleados = idpagosEmpleados;
    }

    public Integer getIdpagosEmpleados() {
        return idpagosEmpleados;
    }

    public void setIdpagosEmpleados(Integer idpagosEmpleados) {
        this.idpagosEmpleados = idpagosEmpleados;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getPagoValorTotal() {
        return pagoValorTotal;
    }

    public void setPagoValorTotal(String pagoValorTotal) {
        this.pagoValorTotal = pagoValorTotal;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public String getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(String horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(String horasExtra) {
        this.horasExtra = horasExtra;
    }

    public String getHorasDominicales() {
        return horasDominicales;
    }

    public void setHorasDominicales(String horasDominicales) {
        this.horasDominicales = horasDominicales;
    }

    public String getHorasExtraDominicales() {
        return horasExtraDominicales;
    }

    public void setHorasExtraDominicales(String horasExtraDominicales) {
        this.horasExtraDominicales = horasExtraDominicales;
    }

    public String getHorasNocturnas() {
        return horasNocturnas;
    }

    public void setHorasNocturnas(String horasNocturnas) {
        this.horasNocturnas = horasNocturnas;
    }

    public String getHorasExtraNocturnas() {
        return horasExtraNocturnas;
    }

    public void setHorasExtraNocturnas(String horasExtraNocturnas) {
        this.horasExtraNocturnas = horasExtraNocturnas;
    }

    public String getHorasExtraDomiNoc() {
        return horasExtraDomiNoc;
    }

    public void setHorasExtraDomiNoc(String horasExtraDomiNoc) {
        this.horasExtraDomiNoc = horasExtraDomiNoc;
    }

    public String getSubsidioTransporte() {
        return subsidioTransporte;
    }

    public void setSubsidioTransporte(String subsidioTransporte) {
        this.subsidioTransporte = subsidioTransporte;
    }

    public String getSubsidioSalud() {
        return subsidioSalud;
    }

    public void setSubsidioSalud(String subsidioSalud) {
        this.subsidioSalud = subsidioSalud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagosEmpleados != null ? idpagosEmpleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosEmpleados)) {
            return false;
        }
        PagosEmpleados other = (PagosEmpleados) object;
        if ((this.idpagosEmpleados == null && other.idpagosEmpleados != null) || (this.idpagosEmpleados != null && !this.idpagosEmpleados.equals(other.idpagosEmpleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PagosEmpleados[ idpagosEmpleados=" + idpagosEmpleados + " ]";
    }
    
}
