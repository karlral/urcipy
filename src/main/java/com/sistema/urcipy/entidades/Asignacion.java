package com.sistema.urcipy.entidades;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="asignacion"
    ,catalog="urcipy"
)
public class Asignacion {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idasignacion", unique=true, nullable=false)
     private int idasignacion;
    @Column(name="nomasignacion", length=60)
     private String nomasignacion;
     private Byte tipoAsignacion;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="asignacion")
    @JsonIgnore
    private Set<EventoAsignacion> eventoAsignacions = new HashSet<EventoAsignacion>(0);

    public Asignacion() {
    }

    public Asignacion( String nomasignacion, Byte tipoAsignacion, Set<EventoAsignacion> eventoAsignacions) {
       this.nomasignacion = nomasignacion;
       this.tipoAsignacion = tipoAsignacion;
       this.eventoAsignacions = eventoAsignacions;
    }

    public int getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(int idasignacion) {
        this.idasignacion = idasignacion;
    }

    public String getNomasignacion() {
        return nomasignacion;
    }

    public void setNomasignacion(String nomasignacion) {
        this.nomasignacion = nomasignacion;
    }

    public Byte getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(Byte tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public Set<EventoAsignacion> getEventoAsignacions() {
        return eventoAsignacions;
    }

    public void setEventoAsignacions(Set<EventoAsignacion> eventoAsignacions) {
        this.eventoAsignacions = eventoAsignacions;
    }
}


