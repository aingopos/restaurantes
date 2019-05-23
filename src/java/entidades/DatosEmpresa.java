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
@Table(name = "datosEmpresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosEmpresa.findAll", query = "SELECT d FROM DatosEmpresa d"),
    @NamedQuery(name = "DatosEmpresa.findByDatEmpId", query = "SELECT d FROM DatosEmpresa d WHERE d.datEmpId = :datEmpId"),
    @NamedQuery(name = "DatosEmpresa.findByDatEmpNombre", query = "SELECT d FROM DatosEmpresa d WHERE d.datEmpNombre = :datEmpNombre"),
    @NamedQuery(name = "DatosEmpresa.findByDatEmpTelefono", query = "SELECT d FROM DatosEmpresa d WHERE d.datEmpTelefono = :datEmpTelefono")})
public class DatosEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dat_emp_id")
    private Integer datEmpId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dat_emp_nombre")
    private String datEmpNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "dat_emp_razon_social")
    private String datEmpRazonSocial;
    @Size(max = 45)
    @Column(name = "dat_emp_telefono")
    private String datEmpTelefono;
    @Lob
    @Size(max = 65535)
    @Column(name = "dat_emp_nit")
    private String datEmpNit;
    @Lob
    @Size(max = 65535)
    @Column(name = "dat_emp_direccion")
    private String datEmpDireccion;
    @Lob
    @Size(max = 65535)
    @Column(name = "dat_emp_email")
    private String datEmpEmail;
    @Lob
    @Size(max = 65535)
    @Column(name = "dat_emp_pagina_web")
    private String datEmpPaginaWeb;

    public DatosEmpresa() {
    }

    public DatosEmpresa(Integer datEmpId) {
        this.datEmpId = datEmpId;
    }

    public DatosEmpresa(Integer datEmpId, String datEmpNombre) {
        this.datEmpId = datEmpId;
        this.datEmpNombre = datEmpNombre;
    }

    public Integer getDatEmpId() {
        return datEmpId;
    }

    public void setDatEmpId(Integer datEmpId) {
        this.datEmpId = datEmpId;
    }

    public String getDatEmpNombre() {
        return datEmpNombre;
    }

    public void setDatEmpNombre(String datEmpNombre) {
        this.datEmpNombre = datEmpNombre;
    }

    public String getDatEmpRazonSocial() {
        return datEmpRazonSocial;
    }

    public void setDatEmpRazonSocial(String datEmpRazonSocial) {
        this.datEmpRazonSocial = datEmpRazonSocial;
    }

    public String getDatEmpTelefono() {
        return datEmpTelefono;
    }

    public void setDatEmpTelefono(String datEmpTelefono) {
        this.datEmpTelefono = datEmpTelefono;
    }

    public String getDatEmpNit() {
        return datEmpNit;
    }

    public void setDatEmpNit(String datEmpNit) {
        this.datEmpNit = datEmpNit;
    }

    public String getDatEmpDireccion() {
        return datEmpDireccion;
    }

    public void setDatEmpDireccion(String datEmpDireccion) {
        this.datEmpDireccion = datEmpDireccion;
    }

    public String getDatEmpEmail() {
        return datEmpEmail;
    }

    public void setDatEmpEmail(String datEmpEmail) {
        this.datEmpEmail = datEmpEmail;
    }

    public String getDatEmpPaginaWeb() {
        return datEmpPaginaWeb;
    }

    public void setDatEmpPaginaWeb(String datEmpPaginaWeb) {
        this.datEmpPaginaWeb = datEmpPaginaWeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datEmpId != null ? datEmpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEmpresa)) {
            return false;
        }
        DatosEmpresa other = (DatosEmpresa) object;
        if ((this.datEmpId == null && other.datEmpId != null) || (this.datEmpId != null && !this.datEmpId.equals(other.datEmpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DatosEmpresa[ datEmpId=" + datEmpId + " ]";
    }
    
}
