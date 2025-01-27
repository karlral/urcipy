package com.sistema.urcipy.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ciudad"
    ,catalog="urcipy"
)
public class Ciudad  {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idciudad", unique=true, nullable=false)
     private Integer idciudad;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="pais_idpais", nullable=false)
     private Pais pais;
     private String nomciudad;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="ciudad")
    @JsonIgnore
    private Set<Persona> personas = new HashSet<Persona>(0);

    public Ciudad() {
    }

	
    public Ciudad(Pais pais) {
        this.pais = pais;
    }
    public Ciudad(Pais pais, String nomciudad, Set<Persona> personas) {
       this.pais = pais;
       this.nomciudad = nomciudad;
       this.personas = personas;
    }
   

    public Integer getIdciudad() {
        return this.idciudad;
    }
    
    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }


    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    @Column(name="nomciudad", length=30)
    public String getNomciudad() {
        return this.nomciudad;
    }
    
    public void setNomciudad(String nomciudad) {
        this.nomciudad = nomciudad;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }




}


