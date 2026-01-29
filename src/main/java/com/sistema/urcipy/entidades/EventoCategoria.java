package com.sistema.urcipy.entidades;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="evento_categoria"
    ,catalog="urcipy"
)
public class EventoCategoria {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idevento_categoria", unique=true, nullable=false)
    private int ideventoCategoria;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    private Evento evento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_idcategoria", nullable=false)
    private Categoria categoria;

    public EventoCategoria() {
    }

    public EventoCategoria(Evento evento, Categoria categoria) {
        this.evento = evento;
        this.categoria = categoria;
    }

    public int getIdeventoCategoria() {
        return ideventoCategoria;
    }

    public void setIdeventoCategoria(int ideventoCategoria) {
        this.ideventoCategoria = ideventoCategoria;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
