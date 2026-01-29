package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.EventoCategoria;
import com.sistema.urcipy.entidades.Categoria;

import java.util.Set;


public interface EventoCategoriaService {

    public EventoCategoria guardarEventoCategoria(EventoCategoria eventoCategoria);

    public Set<EventoCategoria> obtenerEventoCategoriaes();
    public Set<Categoria> obtenerCategoriasEvento(Integer idevento);

    public EventoCategoria obtenerEventoCategoria(Integer ideventoCategoria);

    public void eliminarEventoCategoria(Integer ideventoCategoria);

}
