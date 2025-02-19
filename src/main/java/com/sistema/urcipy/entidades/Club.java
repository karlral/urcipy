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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Club generated by hbm2java
 */
@Entity
@Table(name="club"
    ,catalog="urcipy"
)
public class Club   {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idclub", unique=true, nullable=false)
     private Integer idclub;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="region_idregion", nullable=false)
     private Region region;
     private String nomclub;
     private String presidente;
     private String telpresi;
     private String vicepresidente;
     private String telvice;
     private String telefono;
     private String email;
     private String ruta;
     private String rutagrande;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="club")
    @JsonIgnore
     private Set<Evento> eventos = new HashSet<Evento>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="club")
    @JsonIgnore
     private Set<Campeones> campeoneses = new HashSet<Campeones>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="club")
    @JsonIgnore
    private Set<Corredor> corredors = new HashSet<Corredor>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="club")
    @JsonIgnore
    private Set<Participante> participantes = new HashSet<>(0);

    public Club() {
    }

	
    public Club(Regional regional, Region region) {
        this.region = region;
    }
    public Club( Region region, String nomclub, String presidente, String telpresi, String vicepresidente, String telvice, String telefono, String email, String ruta, String rutagrande, Set<Evento> eventos, Set<Campeones> campeoneses, Set<Participante> participantes) {

        this.region = region;
        this.nomclub = nomclub;
       this.presidente = presidente;
       this.telpresi = telpresi;
       this.vicepresidente = vicepresidente;
       this.telvice = telvice;
       this.telefono = telefono;
       this.email = email;
       this.ruta = ruta;
       this.rutagrande = rutagrande;
       this.eventos = eventos;
       this.campeoneses = campeoneses;

       this.participantes=participantes;
    }
   

    public Integer getIdclub() {
        return this.idclub;
    }
    
    public void setIdclub(Integer idclub) {
        this.idclub = idclub;
    }



    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Column(name="nomclub", length=45)
    public String getNomclub() {
        return this.nomclub;
    }
    
    public void setNomclub(String nomclub) {
        this.nomclub = nomclub;
    }

    
    @Column(name="presidente", length=45)
    public String getPresidente() {
        return this.presidente;
    }
    
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    
    @Column(name="telpresi", length=45)
    public String getTelpresi() {
        return this.telpresi;
    }
    
    public void setTelpresi(String telpresi) {
        this.telpresi = telpresi;
    }

    
    @Column(name="vicepresidente", length=45)
    public String getVicepresidente() {
        return this.vicepresidente;
    }
    
    public void setVicepresidente(String vicepresidente) {
        this.vicepresidente = vicepresidente;
    }

    
    @Column(name="telvice", length=45)
    public String getTelvice() {
        return this.telvice;
    }
    
    public void setTelvice(String telvice) {
        this.telvice = telvice;
    }

    
    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="ruta", length=45)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    @Column(name="rutagrande", length=45)
    public String getRutagrande() {
        return this.rutagrande;
    }
    
    public void setRutagrande(String rutagrande) {
        this.rutagrande = rutagrande;
    }

    public Set<Evento> getEventos() {
        return this.eventos;
    }
    
    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<Campeones> getCampeoneses() {
        return this.campeoneses;
    }
    
    public void setCampeoneses(Set<Campeones> campeoneses) {
        this.campeoneses = campeoneses;
    }

    public Set<Corredor> getCorredors() {
        return this.corredors;
    }
    
    public void setCorredors(Set<Corredor> corredors) {
        this.corredors = corredors;
    }


    public Set<Participante> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }



}


