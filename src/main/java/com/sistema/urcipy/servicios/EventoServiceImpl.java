package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento guardarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    @Override
    public Set<Evento> obtenerEventoes() {
        return new LinkedHashSet<>(eventoRepository.findAll());
    }
    @Override
    public Set<Evento> obtenerEventosModo(Integer modo){
        return new LinkedHashSet<>(eventoRepository.findByModoEquals(modo));
    }
    @Override
    public Set<Evento> obtenerEventosCulminados(){
        Calendar fecha=Calendar.getInstance();
        return new LinkedHashSet<>(eventoRepository.findByModoEqualsAndFechaLessThan(0,fecha.getTime()));
    }
    @Override
    public List<Evento> obtenerEventosActivos(){
        return eventoRepository.findByActivoBetween(1,3);
    }
    @Override
    public Evento obtenerEventoActivo(Integer activo){
        return eventoRepository.findByActivo(activo);
    }

    @Override
    public Evento obtenerEvento(Integer idevento) {
        return eventoRepository.findById(idevento).get();
    }

    @Override
    public void eliminarEvento(Integer idevento) {
        Evento evento= new Evento();
        evento.setIdevento(idevento);
        eventoRepository.delete(evento);
    }
}
