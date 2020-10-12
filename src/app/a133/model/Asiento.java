/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author victo
 */
public class Asiento {
    private Long id_asiento;
    private java.sql.Date fecha;
    private String leyenda;

    public Asiento() {
    }

    public Long getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(Long id_asiento) {
        this.id_asiento = id_asiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getLeyenda(){
        return leyenda;
    }
    
    public void setLeyenda(String leyenda){
        this.leyenda = leyenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_asiento);
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.leyenda);
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
        final Asiento other = (Asiento) obj;
        if (!Objects.equals(this.leyenda, other.leyenda)) {
            return false;
        }
        if (!Objects.equals(this.id_asiento, other.id_asiento)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asiento{" + "id_asiento=" + id_asiento + ", fecha=" + fecha + ", leyenda=" + leyenda + '}';
    }


    
    
}
