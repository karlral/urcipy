package com.sistema.urcipy.entidades;
// Generated 03/02/2023 12:59:13 AM by Hibernate Tools 4.3.1


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
 * Regional generated by hbm2java
 */
@Entity
@Table(name="regional"
    ,catalog="urcipy"
)
public class Regional  implements java.io.Serializable {


     private Integer idregional;
     private String nomregional;
     private String nomcorto;
     private String telefono;
     private String direccion;
     private String email;
     private String presentacion;
     private String quien;
     private String clubes;
     private String icono;
     private String logo;
     private String frenteabajo1;
     private String frenteabajo2;
     private String frenteabajo3;
     private String regionalcol;
     private Integer avisoactivo;
     private String avisoruta;
     private Set<Concepto> conceptos = new HashSet<>(0);
     private Set<Campeones> campeoneses = new HashSet<>(0);
     private Set<Auspicio> auspicios = new HashSet<>(0);
     private Set<Promocion> promocions = new HashSet<>(0);
    private Set<Participante> participantes = new HashSet<>(0);
     private Set<Usuario> usuarios = new HashSet<>(0);

     private Set<Club> clubs = new HashSet<>(0);

    public Regional() {
    }

    public Regional(String nomregional, String nomcorto, String telefono, String direccion, String email, String presentacion, String quien, String clubes, String icono, String logo, String frenteabajo1, String frenteabajo2, String frenteabajo3, String regionalcol, Integer avisoactivo, String avisoruta, Set conceptos, Set<Campeones> campeoneses, Set auspicios, Set promocions, Set usuarios, Set clubs, Set participantes) {
       this.nomregional = nomregional;
       this.nomcorto = nomcorto;
       this.telefono = telefono;
       this.direccion = direccion;
       this.email = email;
       this.presentacion = presentacion;
       this.quien = quien;
       this.clubes = clubes;
       this.icono = icono;
       this.logo = logo;
       this.frenteabajo1 = frenteabajo1;
       this.frenteabajo2 = frenteabajo2;
       this.frenteabajo3 = frenteabajo3;
       this.regionalcol = regionalcol;
       this.avisoactivo = avisoactivo;
       this.avisoruta = avisoruta;
       this.conceptos = conceptos;
       this.campeoneses = campeoneses;
       this.auspicios = auspicios;
       this.promocions = promocions;
       this.usuarios = usuarios;
        this.participantes=participantes;
       this.clubs = clubs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idregional", unique=true, nullable=false)
    public Integer getIdregional() {
        return this.idregional;
    }
    
    public void setIdregional(Integer idregional) {
        this.idregional = idregional;
    }

    
    @Column(name="nomregional", length=45)
    public String getNomregional() {
        return this.nomregional;
    }
    
    public void setNomregional(String nomregional) {
        this.nomregional = nomregional;
    }

    
    @Column(name="nomcorto", length=15)
    public String getNomcorto() {
        return this.nomcorto;
    }
    
    public void setNomcorto(String nomcorto) {
        this.nomcorto = nomcorto;
    }

    
    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="presentacion", length=65535)
    public String getPresentacion() {
        return this.presentacion;
    }
    
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    
    @Column(name="quien", length=45)
    public String getQuien() {
        return this.quien;
    }
    
    public void setQuien(String quien) {
        this.quien = quien;
    }

    
    @Column(name="clubes", length=45)
    public String getClubes() {
        return this.clubes;
    }
    
    public void setClubes(String clubes) {
        this.clubes = clubes;
    }

    
    @Column(name="icono", length=45)
    public String getIcono() {
        return this.icono;
    }
    
    public void setIcono(String icono) {
        this.icono = icono;
    }

    
    @Column(name="logo", length=45)
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    
    @Column(name="frenteabajo1", length=45)
    public String getFrenteabajo1() {
        return this.frenteabajo1;
    }
    
    public void setFrenteabajo1(String frenteabajo1) {
        this.frenteabajo1 = frenteabajo1;
    }

    
    @Column(name="frenteabajo2", length=45)
    public String getFrenteabajo2() {
        return this.frenteabajo2;
    }
    
    public void setFrenteabajo2(String frenteabajo2) {
        this.frenteabajo2 = frenteabajo2;
    }

    
    @Column(name="frenteabajo3", length=45)
    public String getFrenteabajo3() {
        return this.frenteabajo3;
    }
    
    public void setFrenteabajo3(String frenteabajo3) {
        this.frenteabajo3 = frenteabajo3;
    }

    
    @Column(name="regionalcol", length=45)
    public String getRegionalcol() {
        return this.regionalcol;
    }
    
    public void setRegionalcol(String regionalcol) {
        this.regionalcol = regionalcol;
    }

    
    @Column(name="avisoactivo")
    public Integer getAvisoactivo() {
        return this.avisoactivo;
    }
    
    public void setAvisoactivo(Integer avisoactivo) {
        this.avisoactivo = avisoactivo;
    }

    
    @Column(name="avisoruta", length=45)
    public String getAvisoruta() {
        return this.avisoruta;
    }
    
    public void setAvisoruta(String avisoruta) {
        this.avisoruta = avisoruta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Concepto> getConceptos() {
        return this.conceptos;
    }
    
    public void setConceptos(Set<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Campeones> getCampeoneses() {
        return this.campeoneses;
    }
    
    public void setCampeoneses(Set<Campeones> campeoneses) {
        this.campeoneses = campeoneses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Auspicio> getAuspicios() {
        return this.auspicios;
    }
    
    public void setAuspicios(Set<Auspicio> auspicios) {
        this.auspicios = auspicios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Promocion> getPromocions() {
        return this.promocions;
    }
    
    public void setPromocions(Set<Promocion> promocions) {
        this.promocions = promocions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
    @JsonIgnore
    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="regional")
@JsonIgnore
    public Set<Club> getClubs() {
        return this.clubs;
    }
    
    public void setClubs(Set clubs) {
        this.clubs = clubs;
    }


}


