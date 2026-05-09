package com.sistema.urcipy.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="campeonato"
    ,catalog="urcipy"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Campeonato {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idcampeonato", unique=true, nullable=false)
     private Integer idcampeonato;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
     private Regional regional;
    @Column(name="nomcampeonato", length=45)
     private String nomcampeonato;
    @Column(name="ruta", length=60)
     private String ruta;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="campeonato")
    @JsonIgnore
    private Set<Evento> eventos = new HashSet<>(0);

    public Campeonato() {
    }

    public Campeonato(Regional regional) {
        this.regional = regional;

    }

    public Campeonato(Regional regional,  String nomcampeonato, String ruta, Set<Evento> eventos) {
        this.regional = regional;
        this.nomcampeonato = nomcampeonato;
        this.ruta = ruta;
        this.eventos = eventos;
    }

    public Integer getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public String getNomcampeonato() {
        return nomcampeonato;
    }

    public void setNomcampeonato(String nomcampeonato) {
        this.nomcampeonato = nomcampeonato;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}


