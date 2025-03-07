package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="modalidad"
    ,catalog="urcipy"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modalidad {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idmodalidad", unique=true, nullable=false)
     private Integer idmodalidad;
     private String nommodalidad;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="modalidad")
    @JsonIgnore
     private Set<Categoria> categorias = new HashSet<Categoria>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="modalidad")
    @JsonIgnore
    private Set<Club> clubs = new HashSet<Club>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="modalidad")
    @JsonIgnore
    private Set<Evento> eventos = new HashSet<Evento>(0);

    public Modalidad() {
    }

    public Modalidad(String nommodalidad, Set<Categoria> categorias, Set<Club> clubs, Set<Evento> eventos) {
        this.nommodalidad = nommodalidad;
        this.categorias = categorias;
        this.clubs = clubs;
        this.eventos = eventos;
    }

    public Integer getIdmodalidad() {
        return this.idmodalidad;
    }
    
    public void setIdmodalidad(Integer idmodalidad) {
        this.idmodalidad = idmodalidad;
    }

    
    @Column(name="nommodalidad", length=20)
    public String getNommodalidad() {
        return this.nommodalidad;
    }
    
    public void setNommodalidad(String nommodalidad) {
        this.nommodalidad = nommodalidad;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}


