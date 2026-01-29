package com.sistema.urcipy.entidades;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="evento_remera"
    ,catalog="urcipy"
)
public class EventoRemera {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idevento_remera", unique=true, nullable=false)
    private int ideventoRemera;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    private Evento evento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="remera_idremera", nullable=false)
    private Remera remera;

    public EventoRemera() {
    }

    public EventoRemera(Evento evento, Remera remera) {
        this.evento = evento;
        this.remera = remera;
    }

    public int getIdeventoRemera() {
        return ideventoRemera;
    }

    public void setIdeventoRemera(int ideventoRemera) {
        this.ideventoRemera = ideventoRemera;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Remera getRemera() {
        return remera;
    }

    public void setRemera(Remera remera) {
        this.remera = remera;
    }
}
