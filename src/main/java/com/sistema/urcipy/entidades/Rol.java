package com.sistema.urcipy.entidades;
// Generated 03/02/2023 12:59:13 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name="rol"
    ,catalog="urcipy"
)
public class Rol implements Serializable {


     private int idrol;
     private String nombre;

    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol() {
    }

	
    public Rol(int idrol) {
        this.idrol = idrol;
    }
    public Rol(int idrol, String nombre, Set<UsuarioRol> usuarioRoles) {
       this.idrol = idrol;
       this.nombre = nombre;
       this.usuarioRoles = usuarioRoles;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idrol", unique=true, nullable=false)
    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }


    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    @JsonIgnore
    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}


