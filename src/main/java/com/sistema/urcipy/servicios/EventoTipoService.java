package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.EventoTipo;
import com.sistema.urcipy.entidades.Tipo;

import java.util.Set;


public interface EventoTipoService {

    public EventoTipo guardarEventoTipo(EventoTipo eventoTipo);

    public Set<EventoTipo> obtenerEventoTipoes();
    public Set<Tipo> obtenerTiposEvento(Integer idevento);

    public EventoTipo obtenerEventoTipo(Integer ideventoTipo);

    public void eliminarEventoTipo(Integer ideventoTipo);

}
