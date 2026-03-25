package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.EventoAsignacion;
import com.sistema.urcipy.entidades.Asignacion;

import java.util.Set;


public interface EventoAsignacionService {

    public EventoAsignacion guardarEventoAsignacion(EventoAsignacion eventoAsignacion);

    public Set<EventoAsignacion> obtenerEventoAsignaciones();
    public Set<Asignacion> obtenerAsignacionsEvento(Integer idevento);

    public EventoAsignacion obtenerEventoAsignacion(Integer ideventoAsignacion);

    public void eliminarEventoAsignacion(Integer ideventoAsignacion);

}
