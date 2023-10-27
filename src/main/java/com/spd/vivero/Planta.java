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
@Table(name = "planta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p"),
    @NamedQuery(name = "Planta.findByIdPlanta", query = "SELECT p FROM Planta p WHERE p.idPlanta = :idPlanta"),
    @NamedQuery(name = "Planta.findByNombre", query = "SELECT p FROM Planta p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Planta.findByEsSemilla", query = "SELECT p FROM Planta p WHERE p.esSemilla = :esSemilla"),
    @NamedQuery(name = "Planta.findByEspecie", query = "SELECT p FROM Planta p WHERE p.especie = :especie"),
    @NamedQuery(name = "Planta.findByGenero", query = "SELECT p FROM Planta p WHERE p.genero = :genero")})
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_planta")
    private Integer idPlanta;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "es_semilla")
    private short esSemilla;
    @Basic(optional = false)
    @Column(name = "especie")
    private String especie;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;

    public Planta() {
    }

    public Planta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public Planta(Integer idPlanta, String nombre, short esSemilla, String especie, String genero) {
        this.idPlanta = idPlanta;
        this.nombre = nombre;
        this.esSemilla = esSemilla;
        this.especie = especie;
        this.genero = genero;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEsSemilla() {
        return esSemilla;
    }

    public void setEsSemilla(short esSemilla) {
        this.esSemilla = esSemilla;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanta != null ? idPlanta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.idPlanta == null && other.idPlanta != null) || (this.idPlanta != null && !this.idPlanta.equals(other.idPlanta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spd.vivero.Planta[ idPlanta=" + idPlanta + " ]";
    }
    
}
