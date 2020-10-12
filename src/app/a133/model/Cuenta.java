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
public class Cuenta {
    
    private Long id_cuenta;
    private String codigo;
    private String nombre;
    private boolean recibe_saldo;
    private String tipo_cuenta;
    private Double saldo_actual;

    public Cuenta() {
    }

    public Cuenta(Long id_cuenta, String codigo, String nombre, boolean recibe_saldo, String tipo_cuenta, Double saldo_actual) {
        this.id_cuenta = id_cuenta;
        this.codigo = codigo;
        this.nombre = nombre;
        this.recibe_saldo = recibe_saldo;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_actual = saldo_actual;
    }

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getRecibe_saldo() {
        return recibe_saldo;
    }

    public void setRecibe_saldo(boolean recibe_saldo) {
        this.recibe_saldo = recibe_saldo;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(Double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id_cuenta);
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.recibe_saldo);
        hash = 23 * hash + Objects.hashCode(this.tipo_cuenta);
        hash = 23 * hash + Objects.hashCode(this.saldo_actual);
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo_cuenta, other.tipo_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.id_cuenta, other.id_cuenta)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.recibe_saldo, other.recibe_saldo)) {
            return false;
        }
        if (!Objects.equals(this.saldo_actual, other.saldo_actual)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id_cuenta=" + id_cuenta + ", codigo=" + codigo + ", nombre=" + nombre + ", recibe_saldo=" + recibe_saldo + ", tipo_cuenta=" + tipo_cuenta + ", saldo_actual=" + saldo_actual + '}';
    }
    
    
    
}
