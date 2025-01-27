package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Enlaces generated by hbm2java
 */
@Entity
@Table(name="enlaces"
    ,catalog="urcipy"
)
public class Enlaces   {


     private Integer idenlaces;
     private Evento evento;
     private String nomenlaces;
     private String direccion;
     private String ruta;

    public Enlaces() {
    }

	
    public Enlaces(Evento evento) {
        this.evento = evento;
    }
    public Enlaces(Evento evento, String nomenlaces, String direccion, String ruta) {
       this.evento = evento;
       this.nomenlaces = nomenlaces;
       this.direccion = direccion;
       this.ruta = ruta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idenlaces", unique=true, nullable=false)
    public Integer getIdenlaces() {
        return this.idenlaces;
    }
    
    public void setIdenlaces(Integer idenlaces) {
        this.idenlaces = idenlaces;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    @Column(name="nomenlaces", length=45)
    public String getNomenlaces() {
        return this.nomenlaces;
    }
    
    public void setNomenlaces(String nomenlaces) {
        this.nomenlaces = nomenlaces;
    }

    
    @Column(name="direccion", length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="ruta", length=45)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }




}


