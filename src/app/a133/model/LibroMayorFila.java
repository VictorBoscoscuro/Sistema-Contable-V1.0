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
public class LibroMayorFila {
    
    private String fecha;
    private Long idAsientoRelacionado;
    private Double debe;
    private Double haber;
    private Double saldoParcial;
    private String leyenda;

    public LibroMayorFila() {
    }

    public LibroMayorFila(String fecha, Long idAsientoRelacionado, Double debe, Double haber, Double saldoParcial, String leyenda) {
        this.fecha = fecha;
        this.idAsientoRelacionado = idAsientoRelacionado;
        this.debe = debe;
        this.haber = haber;
        this.saldoParcial = saldoParcial;
        this.leyenda = leyenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdAsientoRelacionado() {
        return idAsientoRelacionado;
    }

    public void setIdAsientoRelacionado(Long idMovimiento) {
        this.idAsientoRelacionado = idMovimiento;
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

    public Double getSaldoParcial() {
        return saldoParcial;
    }

    public void setSaldoParcial(Double saldoParcial) {
        this.saldoParcial = saldoParcial;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + Objects.hashCode(this.idAsientoRelacionado);
        hash = 89 * hash + Objects.hashCode(this.debe);
        hash = 89 * hash + Objects.hashCode(this.haber);
        hash = 89 * hash + Objects.hashCode(this.saldoParcial);
        hash = 89 * hash + Objects.hashCode(this.leyenda);
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
        final LibroMayorFila other = (LibroMayorFila) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.idAsientoRelacionado, other.idAsientoRelacionado)) {
            return false;
        }
        if (!Objects.equals(this.debe, other.debe)) {
            return false;
        }
        if (!Objects.equals(this.haber, other.haber)) {
            return false;
        }
        if (!Objects.equals(this.saldoParcial, other.saldoParcial)) {
            return false;
        }
        if (!Objects.equals(this.leyenda, other.leyenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LibroMayorFila{" + "fecha=" + fecha + ", idAsientoRelacionado=" + idAsientoRelacionado + ", debe=" + debe + ", haber=" + haber + ", saldoParcial=" + saldoParcial + '}';
    }
    
    
    
}
