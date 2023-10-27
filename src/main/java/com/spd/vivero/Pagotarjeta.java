/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.vivero;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscarloha
 */
@Entity
@Table(name = "pagotarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagotarjeta.findAll", query = "SELECT p FROM Pagotarjeta p"),
    @NamedQuery(name = "Pagotarjeta.findByIdPagoTarjeta", query = "SELECT p FROM Pagotarjeta p WHERE p.idPagoTarjeta = :idPagoTarjeta"),
    @NamedQuery(name = "Pagotarjeta.findByTipoTarjeta", query = "SELECT p FROM Pagotarjeta p WHERE p.tipoTarjeta = :tipoTarjeta")})
public class Pagotarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_tarjeta")
    private Integer idPagoTarjeta;
    @Basic(optional = false)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;

    public Pagotarjeta() {
    }

    public Pagotarjeta(Integer idPagoTarjeta) {
        this.idPagoTarjeta = idPagoTarjeta;
    }

    public Pagotarjeta(Integer idPagoTarjeta, String tipoTarjeta) {
        this.idPagoTarjeta = idPagoTarjeta;
        this.tipoTarjeta = tipoTarjeta;
    }

    public Integer getIdPagoTarjeta() {
        return idPagoTarjeta;
    }

    public void setIdPagoTarjeta(Integer idPagoTarjeta) {
        this.idPagoTarjeta = idPagoTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoTarjeta != null ? idPagoTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagotarjeta)) {
            return false;
        }
        Pagotarjeta other = (Pagotarjeta) object;
        if ((this.idPagoTarjeta == null && other.idPagoTarjeta != null) || (this.idPagoTarjeta != null && !this.idPagoTarjeta.equals(other.idPagoTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spd.vivero.Pagotarjeta[ idPagoTarjeta=" + idPagoTarjeta + " ]";
    }
    
}
