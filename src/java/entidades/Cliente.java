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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Cliente.findByCliApellidos", query = "SELECT c FROM Cliente c WHERE c.cliApellidos = :cliApellidos"),
    @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Cliente.findByCliCelular", query = "SELECT c FROM Cliente c WHERE c.cliCelular = :cliCelular"),
    @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "Cliente.findByCliCorreo", query = "SELECT c FROM Cliente c WHERE c.cliCorreo = :cliCorreo"),
    @NamedQuery(name = "Cliente.findByCliClave", query = "SELECT c FROM Cliente c WHERE c.cliClave = :cliClave")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 45)
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Size(max = 45)
    @Column(name = "cli_apellidos")
    private String cliApellidos;
    @Column(name = "cli_telefono")
    private Integer cliTelefono;
    @Size(max = 45)
    @Column(name = "cli_celular")
    private String cliCelular;
    @Size(max = 45)
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Size(max = 45)
    @Column(name = "cli_correo")
    private String cliCorreo;
    @Size(max = 45)
    @Column(name = "cli_clave")
    private String cliClave;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public Integer getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(Integer cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    public String getCliClave() {
        return cliClave;
    }

    public void setCliClave(String cliClave) {
        this.cliClave = cliClave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
