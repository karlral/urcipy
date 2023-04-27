package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

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
