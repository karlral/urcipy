package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.EventoRemera;
import com.sistema.urcipy.entidades.Remera;
import com.sistema.urcipy.entidades.Tipo;

import java.util.Set;


public interface EventoRemeraService {

    public EventoRemera guardarEventoRemera(EventoRemera eventoRemera);

    public Set<EventoRemera> obtenerEventoRemeraes();
    public Set<Remera> obtenerRemerasEvento(Integer idevento);

    public EventoRemera obtenerEventoRemera(Integer ideventoRemera);

    public void eliminarEventoRemera(Integer ideventoRemera);

}
