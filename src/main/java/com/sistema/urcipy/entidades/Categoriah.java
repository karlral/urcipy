package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoriah generated by hbm2java
 */
@Entity
@Table(name="categoriah"
    ,catalog="urcipy"
)
public class Categoriah   {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idcategoriah", unique=true, nullable=false)
     private Integer idcategoriah;
     private String nomcategoria;
     private String nomcorto;
     private Integer ano;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="categoriah")
    @JsonIgnore
     private Set<Campeones> campeoneses = new HashSet<Campeones>(0);

    public Categoriah() {
    }

    public Categoriah(String nomcategoria, String nomcorto, Integer ano, Set<Campeones> campeoneses) {
       this.nomcategoria = nomcategoria;
       this.nomcorto = nomcorto;
       this.ano = ano;
       this.campeoneses = campeoneses;
    }
   

    public Integer getIdcategoriah() {
        return this.idcategoriah;
    }
    
    public void setIdcategoriah(Integer idcategoriah) {
        this.idcategoriah = idcategoriah;
    }

    
    @Column(name="nomcategoria", length=60)
    public String getNomcategoria() {
        return this.nomcategoria;
    }
    
    public void setNomcategoria(String nomcategoria) {
        this.nomcategoria = nomcategoria;
    }

    
    @Column(name="nomcorto", length=45)
    public String getNomcorto() {
        return this.nomcorto;
    }
    
    public void setNomcorto(String nomcorto) {
        this.nomcorto = nomcorto;
    }

    
    @Column(name="ano")
    public Integer getAno() {
        return this.ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }


    public Set<Campeones> getCampeoneses() {
        return this.campeoneses;
    }
    
    public void setCampeoneses(Set<Campeones> campeoneses) {
        this.campeoneses = campeoneses;
    }




}


