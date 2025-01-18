package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Evento;

import java.util.List;
import java.util.Set;


public interface EventoService {

    public Evento guardarEvento(Evento evento);

    public Set<Evento> obtenerEventoes(Integer idregional);

    public Set<Evento> obtenerEventosModo(Integer modo, Integer idregional);
    public Set<Evento> obtenerEventosCulminados(Integer idregional);
    public List<Evento> obtenerEventosActivos(Integer idregional);
    public Evento obtenerEventoActivo(Integer activo);

    public Evento obtenerEvento(Integer idevento);

    public void eliminarEvento(Integer idevento);

}
