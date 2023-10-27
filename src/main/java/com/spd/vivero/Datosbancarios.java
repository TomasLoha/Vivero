/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.vivero;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscarloha
 */
@Entity
@Table(name = "datosbancarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosbancarios.findAll", query = "SELECT d FROM Datosbancarios d"),
    @NamedQuery(name = "Datosbancarios.findByIdDatosBancarios", query = "SELECT d FROM Datosbancarios d WHERE d.idDatosBancarios = :idDatosBancarios"),
    @NamedQuery(name = "Datosbancarios.findByNumeroTarjeta", query = "SELECT d FROM Datosbancarios d WHERE d.numeroTarjeta = :numeroTarjeta"),
    @NamedQuery(name = "Datosbancarios.findByTipoTarjeta", query = "SELECT d FROM Datosbancarios d WHERE d.tipoTarjeta = :tipoTarjeta"),
    @NamedQuery(name = "Datosbancarios.findByFechaVencimiento", query = "SELECT d FROM Datosbancarios d WHERE d.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Datosbancarios.findByCodigoSeguridad", query = "SELECT d FROM Datosbancarios d WHERE d.codigoSeguridad = :codigoSeguridad")})
public class Datosbancarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datos_bancarios")
    private Integer idDatosBancarios;
    @Basic(optional = false)
    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;
    @Basic(optional = false)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @Basic(optional = false)
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "codigo_seguridad")
    private int codigoSeguridad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_email")
    @ManyToOne(optional = false)
    private User idUsuario;

    public Datosbancarios() {
    }

    public Datosbancarios(Integer idDatosBancarios) {
        this.idDatosBancarios = idDatosBancarios;
    }

    public Datosbancarios(Integer idDatosBancarios, int numeroTarjeta, String tipoTarjeta, Date fechaVencimiento, int codigoSeguridad) {
        this.idDatosBancarios = idDatosBancarios;
        this.numeroTarjeta = numeroTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    public Integer getIdDatosBancarios() {
        return idDatosBancarios;
    }

    public void setIdDatosBancarios(Integer idDatosBancarios) {
        this.idDatosBancarios = idDatosBancarios;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public User getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(User idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosBancarios != null ? idDatosBancarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosbancarios)) {
            return false;
        }
        Datosbancarios other = (Datosbancarios) object;
        if ((this.idDatosBancarios == null && other.idDatosBancarios != null) || (this.idDatosBancarios != null && !this.idDatosBancarios.equals(other.idDatosBancarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spd.vivero.Datosbancarios[ idDatosBancarios=" + idDatosBancarios + " ]";
    }
    
}
