package com.sistema.urcipy.entidades;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="evento_asignacion"
    ,catalog="urcipy"
)
public class EventoAsignacion {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idevento_asignacion", unique=true, nullable=false)
    private int ideventoAsignacion;
    private Date fecha;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
    private Evento evento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asignacion_idasignacion", nullable=false)
    private Asignacion asignacion;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="corredor_idcorredor", nullable=false)
    private Corredor corredor;
    private Integer puntaje;
    private Integer idparticipante;


    public EventoAsignacion() {
    }

    public EventoAsignacion(Date fecha, Evento evento, Asignacion asignacion, Corredor corredor, Integer puntaje, Integer idparticipante) {
        this.fecha = fecha;
        this.evento = evento;
        this.asignacion = asignacion;
        this.corredor = corredor;
        this.puntaje = puntaje;
        this.idparticipante = idparticipante;
    }

    public int getIdeventoAsignacion() {
        return ideventoAsignacion;
    }

    public void setIdeventoAsignacion(int ideventoAsignacion) {
        this.ideventoAsignacion = ideventoAsignacion;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(Integer idparticipante) {
        this.idparticipante = idparticipante;
    }
}
