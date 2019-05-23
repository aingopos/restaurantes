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
import javax.persistence.Lob;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProvCedula", query = "SELECT p FROM Proveedor p WHERE p.provCedula = :provCedula"),
    @NamedQuery(name = "Proveedor.findByProvNombre", query = "SELECT p FROM Proveedor p WHERE p.provNombre = :provNombre"),
    @NamedQuery(name = "Proveedor.findByProvApellidos", query = "SELECT p FROM Proveedor p WHERE p.provApellidos = :provApellidos"),
    @NamedQuery(name = "Proveedor.findByProvTelefono", query = "SELECT p FROM Proveedor p WHERE p.provTelefono = :provTelefono"),
    @NamedQuery(name = "Proveedor.findByProvCelular", query = "SELECT p FROM Proveedor p WHERE p.provCelular = :provCelular"),
    @NamedQuery(name = "Proveedor.findByProvCorreo", query = "SELECT p FROM Proveedor p WHERE p.provCorreo = :provCorreo")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_cedula")
    private Integer provCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prov_nombre")
    private String provNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prov_apellidos")
    private String provApellidos;
    @Size(max = 45)
    @Column(name = "prov_telefono")
    private String provTelefono;
    @Size(max = 45)
    @Column(name = "prov_celular")
    private String provCelular;
    @Lob
    @Size(max = 65535)
    @Column(name = "prov_reputacion")
    private String provReputacion;
    @Size(max = 45)
    @Column(name = "prov_correo")
    private String provCorreo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prov_pagina_web")
    private String provPaginaWeb;

    public Proveedor() {
    }

    public Proveedor(Integer provCedula) {
        this.provCedula = provCedula;
    }

    public Proveedor(Integer provCedula, String provNombre, String provApellidos, String provPaginaWeb) {
        this.provCedula = provCedula;
        this.provNombre = provNombre;
        this.provApellidos = provApellidos;
        this.provPaginaWeb = provPaginaWeb;
    }

    public Integer getProvCedula() {
        return provCedula;
    }

    public void setProvCedula(Integer provCedula) {
        this.provCedula = provCedula;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    public String getProvApellidos() {
        return provApellidos;
    }

    public void setProvApellidos(String provApellidos) {
        this.provApellidos = provApellidos;
    }

    public String getProvTelefono() {
        return provTelefono;
    }

    public void setProvTelefono(String provTelefono) {
        this.provTelefono = provTelefono;
    }

    public String getProvCelular() {
        return provCelular;
    }

    public void setProvCelular(String provCelular) {
        this.provCelular = provCelular;
    }

    public String getProvReputacion() {
        return provReputacion;
    }

    public void setProvReputacion(String provReputacion) {
        this.provReputacion = provReputacion;
    }

    public String getProvCorreo() {
        return provCorreo;
    }

    public void setProvCorreo(String provCorreo) {
        this.provCorreo = provCorreo;
    }

    public String getProvPaginaWeb() {
        return provPaginaWeb;
    }

    public void setProvPaginaWeb(String provPaginaWeb) {
        this.provPaginaWeb = provPaginaWeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provCedula != null ? provCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.provCedula == null && other.provCedula != null) || (this.provCedula != null && !this.provCedula.equals(other.provCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proveedor[ provCedula=" + provCedula + " ]";
    }
    
}
