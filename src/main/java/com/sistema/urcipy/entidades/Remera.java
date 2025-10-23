package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="remera"
    ,catalog="urcipy"
)
public class Remera {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idremera", unique=true, nullable=false)
     private Integer idremera;
     private String nomremera;


    public Remera() {
    }

    public Remera(String nomremera) {
       this.nomremera = nomremera;

    }
   

    public Integer getIdremera() {
        return this.idremera;
    }
    
    public void setIdremera(Integer idremera) {
        this.idremera = idremera;
    }

    
    @Column(name="nomremera", length=20)
    public String getNomremera() {
        return this.nomremera;
    }
    
    public void setNomremera(String nomremera) {
        this.nomremera = nomremera;
    }




}


