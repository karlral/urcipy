package com.sistema.urcipy.entidades;
// Generated 03/02/2023 12:59:13 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="region"
        ,catalog="urcipy"
)
public class Region  {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idregion", unique=true, nullable=false)
    private Integer idregion;
    private String nomregion;
    private String nomcorto;
    private String telefono;
    private String direccion;
    private String email;
    private String url;
    private String logo;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="region")
    @JsonIgnore
    private Set<Participante> participantes = new HashSet<Participante>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="region")
    @JsonIgnore
    private Set<Club> clubs = new HashSet<Club>(0);



    public Region() {
    }

    public Region(String nomregion, String nomcorto, String telefono, String direccion, String email, String url, String logo, Set<Club> clubs, Set<Participante> participantes) {
        this.nomregion = nomregion;
        this.nomcorto = nomcorto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.url=url;
        this.logo = logo;
        this.participantes=participantes;
        this.clubs = clubs;

    }


    public Integer getIdregion() {
        return this.idregion;
    }

    public void setIdregion(Integer idregion) {
        this.idregion = idregion;
    }


    @Column(name="nomregion", length=45)
    public String getNomregion() {
        return this.nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
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

    @Column(name="url", length=45)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }


    public Set<Club> getClubs() {
        return this.clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
    @Column(name="logo", length=45)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

