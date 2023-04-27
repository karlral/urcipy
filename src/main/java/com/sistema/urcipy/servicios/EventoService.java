package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Evento;

import java.util.Set;


public interface EventoService {

    public Evento guardarEvento(Evento evento);

    public Set<Evento> obtenerEventoes();

    public Evento obtenerEvento(Integer idevento);

    public void eliminarEvento(Integer idevento);

}
