package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="tipopuntos"
    ,catalog="urcipy"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tipopuntos {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idtipopuntos", unique=true, nullable=false)
    private Integer idtipopuntos;
    @Column(length = 30, nullable=false)
    private String nomtipopuntos;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="tipopuntos")
    @JsonIgnore
    private Set<Evento> eventos = new HashSet<>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="tipopuntos")
    @JsonIgnore
    private Set<Puntaje> puntajes = new HashSet<>(0);

    public Tipopuntos() {
    }

    public Tipopuntos(String nomtipopuntos, Set<Evento> eventos, Set<Puntaje> puntajes) {
        this.nomtipopuntos = nomtipopuntos;
        this.eventos = eventos;
        this.puntajes = puntajes;
    }

    public Tipopuntos(String nomtipopuntos) {
        this.nomtipopuntos = nomtipopuntos;
    }

    public Integer getIdtipopuntos() {
        return idtipopuntos;
    }

    public void setIdtipopuntos(Integer idtipopuntos) {
        this.idtipopuntos = idtipopuntos;
    }

    public String getNomtipopuntos() {
        return nomtipopuntos;
    }

    public void setNomtipopuntos(String nomtipopuntos) {
        this.nomtipopuntos = nomtipopuntos;
    }


    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<Puntaje> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(Set<Puntaje> puntajes) {
        this.puntajes = puntajes;
    }
}


