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
public class Asiento_Cuenta {
    
    private Long id_asiento_cuenta;
    private Long id_cuenta;
    private Long id_asiento;
    private Double saldo_parcial;
    private Double debe;
    private Double haber;

    public Asiento_Cuenta() {
    }

     
    public Long getId_asiento_cuenta() {
        return id_asiento_cuenta;
    }

    public void setId_asiento_cuenta(Long id_asiento_cuenta) {
        this.id_asiento_cuenta = id_asiento_cuenta;
    }

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Long getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(Long id_asiento) {
        this.id_asiento = id_asiento;
    }

    public Double getSaldo_parcial() {
        return saldo_parcial;
    }

    public void setSaldo_parcial(Double saldo_parcial) {
        this.saldo_parcial = saldo_parcial;
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


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id_asiento_cuenta);
        hash = 67 * hash + Objects.hashCode(this.id_cuenta);
        hash = 67 * hash + Objects.hashCode(this.id_asiento);
        hash = 67 * hash + Objects.hashCode(this.saldo_parcial);
        hash = 67 * hash + Objects.hashCode(this.debe);
        hash = 67 * hash + Objects.hashCode(this.haber);
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
        final Asiento_Cuenta other = (Asiento_Cuenta) obj;
        if (!Objects.equals(this.id_asiento_cuenta, other.id_asiento_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.id_cuenta, other.id_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.id_asiento, other.id_asiento)) {
            return false;
        }
        if (!Objects.equals(this.saldo_parcial, other.saldo_parcial)) {
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
        return "Asiento_Cuenta{" + "id_asiento_cuenta=" + id_asiento_cuenta + ", id_cuenta=" + id_cuenta + ", id_asiento=" + id_asiento + ", saldo_parcial=" + saldo_parcial + ", debe=" + debe + ", haber=" + haber + '}';
    }

    
    
    
    
}
