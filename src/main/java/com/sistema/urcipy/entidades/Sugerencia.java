package com.sistema.urcipy.entidades;
// Generated 03/02/2023 12:59:13 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Sugerencia generated by hbm2java
 */
@Entity
@Table(name="sugerencia"
    ,catalog="urcipy"
)
public class Sugerencia  implements java.io.Serializable {


     private int idsugerencia;
     private Evento evento;
     private String nomsugerencia;
     private String comentario;

    public Sugerencia() {
    }

	
    public Sugerencia(int idsugerencia, Evento evento) {
        this.idsugerencia = idsugerencia;
        this.evento = evento;
    }
    public Sugerencia(int idsugerencia, Evento evento, String nomsugerencia, String comentario) {
       this.idsugerencia = idsugerencia;
       this.evento = evento;
       this.nomsugerencia = nomsugerencia;
       this.comentario = comentario;
    }
   
     @Id 

    
    @Column(name="idsugerencia", unique=true, nullable=false)
    public int getIdsugerencia() {
        return this.idsugerencia;
    }
    
    public void setIdsugerencia(int idsugerencia) {
        this.idsugerencia = idsugerencia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idevento", nullable=false)
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    @Column(name="nomsugerencia", length=45)
    public String getNomsugerencia() {
        return this.nomsugerencia;
    }
    
    public void setNomsugerencia(String nomsugerencia) {
        this.nomsugerencia = nomsugerencia;
    }

    
    @Column(name="comentario", length=100)
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }




}

