/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.model;

import java.util.Objects;

/**
 *
 * @author victo
 */
public class LibroDiarioFila {

    private Long id_asiento_cuenta;
    private String codigo_cuenta;
    private String nombre_cuenta;
    private Double debe;
    private Double haber;
    private String leyenda;

    public LibroDiarioFila() {
    }

    public LibroDiarioFila(Long id_asiento_cuenta, String codigo_cuenta, String nombre_cuenta, Double debe, Double haber, String leyenda) {
        this.id_asiento_cuenta = id_asiento_cuenta;
        this.codigo_cuenta = codigo_cuenta;
        this.nombre_cuenta = nombre_cuenta;
        this.debe = debe;
        this.haber = haber;
        this.leyenda = leyenda;
    }

    public Long getId_asiento_cuenta() {
        return id_asiento_cuenta;
    }

    public void setId_asiento_cuenta(Long id_asiento_cuenta) {
        this.id_asiento_cuenta = id_asiento_cuenta;
    }

    public String getCodigo_cuenta() {
        return codigo_cuenta;
    }

    public void setCodigo_cuenta(String codigo_cuenta) {
        this.codigo_cuenta = codigo_cuenta;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroDiarioFila other = (LibroDiarioFila) obj;
        if (!Objects.equals(this.codigo_cuenta, other.codigo_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.nombre_cuenta, other.nombre_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.leyenda, other.leyenda)) {
            return false;
        }
        if (!Objects.equals(this.id_asiento_cuenta, other.id_asiento_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.debe, other.debe)) {
            return false;
        }
        if (!Objects.equals(this.haber, other.haber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LibroDiarioFila{" + "id_asiento_cuenta=" + id_asiento_cuenta + ", codigo_cuenta=" + codigo_cuenta + ", nombre_cuenta=" + nombre_cuenta + ", debe=" + debe + ", haber=" + haber + ", leyenda=" + leyenda + '}';
    }
    
    
    
}
