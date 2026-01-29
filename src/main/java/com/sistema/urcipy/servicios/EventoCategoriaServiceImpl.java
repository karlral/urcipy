package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.EventoCategoria;
import com.sistema.urcipy.entidades.EventoCategoria;
import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.repositorios.EventoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventoCategoriaServiceImpl implements EventoCategoriaService{

    @Autowired
    private EventoCategoriaRepository eventoCategoriaRepository;

    @Override
    public EventoCategoria guardarEventoCategoria(EventoCategoria eventoCategoria){
        return eventoCategoriaRepository.save(eventoCategoria);
    }

    @Override
    public Set<EventoCategoria> obtenerEventoCategoriaes() {
        return new LinkedHashSet<>(eventoCategoriaRepository.findAll());
    }
    @Override
    public Set<Categoria> obtenerCategoriasEvento(Integer idevento) {
        Set<EventoCategoria> eventoCategorias=eventoCategoriaRepository.findAllByEvento_Idevento(idevento);
        return new LinkedHashSet<>(eventoCategorias.stream().map(EventoCategoria::getCategoria).collect(Collectors.toSet()));
    }

    @Override
    public EventoCategoria obtenerEventoCategoria(Integer ideventoCategoria) {
        return eventoCategoriaRepository.findById(ideventoCategoria).get();
    }

    @Override
    public void eliminarEventoCategoria(Integer ideventoCategoria) {
        EventoCategoria eventoCategoria= new EventoCategoria();
        eventoCategoria.setIdeventoCategoria(ideventoCategoria);
        eventoCategoriaRepository.delete(eventoCategoria);
    }
}
