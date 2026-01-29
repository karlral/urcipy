package com.sistema.urcipy.entidades;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="evento_tipo"
    ,catalog="urcipy"
)
public class EventoTipo {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idevento_tipo", unique=true, nullable=false)
    private int ideventoTipo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    private Evento evento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_idtipo", nullable=false)
    private Tipo tipo;

    public EventoTipo() {
    }

    public EventoTipo(Evento evento, Tipo tipo) {
        this.evento = evento;
        this.tipo = tipo;
    }

    public int getIdeventoTipo() {
        return ideventoTipo;
    }

    public void setIdeventoTipo(int ideventoTipo) {
        this.ideventoTipo = ideventoTipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
