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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByEmpleadoCedula", query = "SELECT e FROM Empleado e WHERE e.empleadoCedula = :empleadoCedula"),
    @NamedQuery(name = "Empleado.findByEmpleadoNombre", query = "SELECT e FROM Empleado e WHERE e.empleadoNombre = :empleadoNombre"),
    @NamedQuery(name = "Empleado.findByEmpleadoApellidos", query = "SELECT e FROM Empleado e WHERE e.empleadoApellidos = :empleadoApellidos"),
    @NamedQuery(name = "Empleado.findByEmpleadoTelefono", query = "SELECT e FROM Empleado e WHERE e.empleadoTelefono = :empleadoTelefono"),
    @NamedQuery(name = "Empleado.findByEmpleadoDireccion", query = "SELECT e FROM Empleado e WHERE e.empleadoDireccion = :empleadoDireccion"),
    @NamedQuery(name = "Empleado.findByEmpleadoSalario", query = "SELECT e FROM Empleado e WHERE e.empleadoSalario = :empleadoSalario"),
    @NamedQuery(name = "Empleado.findByEmpleadoFoto", query = "SELECT e FROM Empleado e WHERE e.empleadoFoto = :empleadoFoto"),
    @NamedQuery(name = "Empleado.findByEmpleadoFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.empleadoFechaIngreso = :empleadoFechaIngreso"),
    @NamedQuery(name = "Empleado.findByTipoEmpleado", query = "SELECT e FROM Empleado e WHERE e.tipoEmpleado = :tipoEmpleado"),
    @NamedQuery(name = "Empleado.findByEmpleadoLogin", query = "SELECT e FROM Empleado e WHERE e.empleadoLogin = :empleadoLogin")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado_cedula")
    private Integer empleadoCedula;
    @Size(max = 45)
    @Column(name = "empleado_nombre")
    private String empleadoNombre;
    @Size(max = 45)
    @Column(name = "empleado_apellidos")
    private String empleadoApellidos;
    @Size(max = 45)
    @Column(name = "empleado_telefono")
    private String empleadoTelefono;
    @Size(max = 45)
    @Column(name = "empleado_direccion")
    private String empleadoDireccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "empleado_salario")
    private Double empleadoSalario;
    @Size(max = 100)
    @Column(name = "empleado_foto")
    private String empleadoFoto;
    @Size(max = 45)
    @Column(name = "empleado_fecha_ingreso")
    private String empleadoFechaIngreso;
    @Size(max = 45)
    @Column(name = "tipo_empleado")
    private String tipoEmpleado;
    @Size(max = 45)
    @Column(name = "empleado_login")
    private String empleadoLogin;

    public Empleado() {
    }

    public Empleado(Integer empleadoCedula) {
        this.empleadoCedula = empleadoCedula;
    }

    public Integer getEmpleadoCedula() {
        return empleadoCedula;
    }

    public void setEmpleadoCedula(Integer empleadoCedula) {
        this.empleadoCedula = empleadoCedula;
    }

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public String getEmpleadoApellidos() {
        return empleadoApellidos;
    }

    public void setEmpleadoApellidos(String empleadoApellidos) {
        this.empleadoApellidos = empleadoApellidos;
    }

    public String getEmpleadoTelefono() {
        return empleadoTelefono;
    }

    public void setEmpleadoTelefono(String empleadoTelefono) {
        this.empleadoTelefono = empleadoTelefono;
    }

    public String getEmpleadoDireccion() {
        return empleadoDireccion;
    }

    public void setEmpleadoDireccion(String empleadoDireccion) {
        this.empleadoDireccion = empleadoDireccion;
    }

    public Double getEmpleadoSalario() {
        return empleadoSalario;
    }

    public void setEmpleadoSalario(Double empleadoSalario) {
        this.empleadoSalario = empleadoSalario;
    }

    public String getEmpleadoFoto() {
        return empleadoFoto;
    }

    public void setEmpleadoFoto(String empleadoFoto) {
        this.empleadoFoto = empleadoFoto;
    }

    public String getEmpleadoFechaIngreso() {
        return empleadoFechaIngreso;
    }

    public void setEmpleadoFechaIngreso(String empleadoFechaIngreso) {
        this.empleadoFechaIngreso = empleadoFechaIngreso;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getEmpleadoLogin() {
        return empleadoLogin;
    }

    public void setEmpleadoLogin(String empleadoLogin) {
        this.empleadoLogin = empleadoLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoCedula != null ? empleadoCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoCedula == null && other.empleadoCedula != null) || (this.empleadoCedula != null && !this.empleadoCedula.equals(other.empleadoCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleado[ empleadoCedula=" + empleadoCedula + " ]";
    }
    
}
