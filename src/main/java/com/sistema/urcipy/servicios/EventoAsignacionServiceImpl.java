package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.EventoAsignacion;
import com.sistema.urcipy.entidades.Asignacion;
import com.sistema.urcipy.repositorios.EventoAsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventoAsignacionServiceImpl implements EventoAsignacionService{

    @Autowired
    private EventoAsignacionRepository eventoAsignacionRepository;



    @Override
    public EventoAsignacion guardarEventoAsignacion(EventoAsignacion eventoAsignacion){

        return eventoAsignacionRepository.save(eventoAsignacion);
    }

    @Override
    public Set<EventoAsignacion> obtenerEventoAsignaciones() {
        return new LinkedHashSet<>(eventoAsignacionRepository.findAll());
    }
    @Override
    public Set<Asignacion> obtenerAsignacionsEvento(Integer idevento) {
        Set<EventoAsignacion> eventoAsignacions=eventoAsignacionRepository.findAllByEvento_Idevento(idevento);
        return new LinkedHashSet<>(eventoAsignacions.stream().map(EventoAsignacion::getAsignacion).collect(Collectors.toSet()));
    }

    @Override
    public EventoAsignacion obtenerEventoAsignacion(Integer ideventoAsignacion) {
        return eventoAsignacionRepository.findById(ideventoAsignacion).get();
    }

    @Override
    public void eliminarEventoAsignacion(Integer ideventoAsignacion) {
        EventoAsignacion eventoAsignacion= new EventoAsignacion();
        eventoAsignacion.setIdeventoAsignacion(ideventoAsignacion);
        eventoAsignacionRepository.delete(eventoAsignacion);
    }
}
