package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.EventoRemera;
import com.sistema.urcipy.entidades.EventoRemera;
import com.sistema.urcipy.entidades.Remera;
import com.sistema.urcipy.repositorios.EventoRemeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventoRemeraServiceImpl implements EventoRemeraService{

    @Autowired
    private EventoRemeraRepository eventoRemeraRepository;

    @Override
    public EventoRemera guardarEventoRemera(EventoRemera eventoRemera){
        return eventoRemeraRepository.save(eventoRemera);
    }

    @Override
    public Set<EventoRemera> obtenerEventoRemeraes() {
        return new LinkedHashSet<>(eventoRemeraRepository.findAll());
    }
    @Override
    public Set<Remera> obtenerRemerasEvento(Integer idevento) {
        Set<EventoRemera> eventoRemeras=eventoRemeraRepository.findAllByEvento_Idevento(idevento);
        return new LinkedHashSet<>(eventoRemeras.stream().map(EventoRemera::getRemera).collect(Collectors.toSet()));
    }

    @Override
    public EventoRemera obtenerEventoRemera(Integer ideventoRemera) {
        return eventoRemeraRepository.findById(ideventoRemera).get();
    }

    @Override
    public void eliminarEventoRemera(Integer ideventoRemera) {
        EventoRemera eventoRemera= new EventoRemera();
        eventoRemera.setIdeventoRemera(ideventoRemera);
        eventoRemeraRepository.delete(eventoRemera);
    }
}
