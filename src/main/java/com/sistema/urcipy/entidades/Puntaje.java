package com.sistema.urcipy.entidades;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="puntaje"
    ,catalog="urcipy"
)
public class Puntaje {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idpuntaje", unique=true, nullable=false)
     private Integer idpuntaje;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
     private Regional regional;
     private Integer posicion;
     private Integer puntos;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipopuntos_idtipopuntos", nullable=false)
     private Tipopuntos tipopuntos;

    public Puntaje() {
    }

    public Puntaje(Regional regional, Tipopuntos tipopuntos) {
        this.regional = regional;
        this.tipopuntos = tipopuntos;
    }

    public Puntaje(Regional regional, Integer posicion, Integer puntos, Tipopuntos tipopuntos) {
        this.regional = regional;
        this.posicion = posicion;
        this.puntos = puntos;
        this.tipopuntos = tipopuntos;
    }

    public Integer getIdpuntaje() {
        return idpuntaje;
    }

    public void setIdpuntaje(Integer idpuntaje) {
        this.idpuntaje = idpuntaje;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Tipopuntos getTipopuntos() {
        return tipopuntos;
    }

    public void setTipopuntos(Tipopuntos tipopuntos) {
        this.tipopuntos = tipopuntos;
    }
}


