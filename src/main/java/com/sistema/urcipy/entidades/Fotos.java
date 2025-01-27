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
 * Fotos generated by hbm2java
 */
@Entity
@Table(name="fotos"
    ,catalog="urcipy"
)
public class Fotos   {


     private Integer idfotos;
     private Evento evento;
     private String comentario;
     private String ruta;
     private String titulo;

    public Fotos() {
    }

	
    public Fotos(Evento evento) {
        this.evento = evento;
    }
    public Fotos(Evento evento, String comentario, String ruta, String titulo) {
       this.evento = evento;
       this.comentario = comentario;
       this.ruta = ruta;
       this.titulo = titulo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idfotos", unique=true, nullable=false)
    public Integer getIdfotos() {
        return this.idfotos;
    }
    
    public void setIdfotos(Integer idfotos) {
        this.idfotos = idfotos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    @Column(name="comentario", length=250)
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    @Column(name="ruta", length=45)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    @Column(name="titulo", length=45)
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




}


