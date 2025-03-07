package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="persona"
    ,catalog="urcipy"
)
public class Persona {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idpersona", unique=true, nullable=false)
     private Integer idpersona;
    @Column(name="nombre", length=45)
    private String nombre;
    @Column(name="apellido", length=45)
     private String apellido;
    @Column(name="ci", length=20)
     private String ci;
    @Column(name="sexo")
     private Byte sexo;
    @Temporal(TemporalType.DATE)
    @Column(name="fecnac", length=10)
     private Date fecnac;
    @Column(name="telefono", length=30)
     private String telefono;
    @Column(name="direccion", length=45)
     private String direccion;
    @Column(name="email", length=45)
     private String email;
    @Column(name="foto", length=45)
    private String foto;
    @Column(name="cidelante", length=45)
    private String cidelante;
    @Column(name="gruposanguineo", length=10)
    private String gruposanguineo;
    @Column(name="tutorp", length=45)
    private String tutorp;
    @Column(name="citp", length=15)
    private String citp;
    @Column(name="nacionalidad", length=45)
    private String nacionalidad;
    private Integer tamano;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ciudad_idciudad", nullable=false)
    private Ciudad ciudad;


    @OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    @JsonIgnore
     private Set<Corredor> corredors = new HashSet<Corredor>(0);


    public Persona() {
    }

    public Persona(String nombre, String apellido, String ci, Byte sexo, Date fecnac, String telefono, String direccion, String email, String foto, String cidelante, String gruposanguineo, String tutorp, String citp, String nacionalidad, Integer tamano, Ciudad ciudad, Set<Corredor> corredors) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.sexo = sexo;
        this.fecnac = fecnac;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.foto = foto;
        this.cidelante = cidelante;
        this.gruposanguineo = gruposanguineo;
        this.tutorp = tutorp;
        this.citp = citp;
        this.nacionalidad=nacionalidad;
        this.tamano = tamano;
        this.ciudad = ciudad;
        this.corredors = corredors;
    }

    public Integer getIdpersona() {
        return this.idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getCi() {
        return this.ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }



    public Byte getSexo() {
        return this.sexo;
    }

    public void setSexo(Byte sexo) {
        this.sexo = sexo;
    }


    public Date getFecnac() {
        return this.fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }



    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getCidelante() {
        return this.cidelante;
    }

    public void setCidelante(String cidelante) {
        this.cidelante = cidelante;
    }


    public String getTutorp() {
        return this.tutorp;
    }

    public void setTutorp(String tutorp) {
        this.tutorp = tutorp;
    }


    public String getCitp() {
        return this.citp;
    }

    public void setCitp(String citp) {
        this.citp = citp;
    }



    public String getGruposanguineo() {
        return this.gruposanguineo;
    }

    public void setGruposanguineo(String gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }


    public Set<Corredor> getCorredors() {
        return corredors;
    }

    public void setCorredors(Set<Corredor> corredors) {
        this.corredors = corredors;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }
}


