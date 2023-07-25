package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Evento;

import java.util.List;
import java.util.Set;


public interface EventoService {

    public Evento guardarEvento(Evento evento);

    public Set<Evento> obtenerEventoes();

    public Set<Evento> obtenerEventosModo(Integer modo);
    public Set<Evento> obtenerEventosCulminados();
    public List<Evento> obtenerEventosActivos();
    public Evento obtenerEventoActivo(Integer activo);

    public Evento obtenerEvento(Integer idevento);

    public void eliminarEvento(Integer idevento);

}
