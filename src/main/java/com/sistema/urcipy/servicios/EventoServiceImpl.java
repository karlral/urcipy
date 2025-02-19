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
    public Set<Evento> obtenerEventoes(Integer idregional) {
        return new LinkedHashSet<>(eventoRepository.findByRegional_Idregional(idregional));
    }
    @Override
    public Set<Evento> obtenerEventosModo(Integer modo,Integer idregional){
        return new LinkedHashSet<>(eventoRepository.findByModoEqualsAndRegional_idregional(modo,idregional));
    }
    @Override
    public Set<Evento> obtenerEventosCulminados(Integer idregional){
        Calendar fecha=Calendar.getInstance();
        return new LinkedHashSet<>(eventoRepository.findByModoEqualsAndFechaLessThanAndRegional_idregional(0,fecha.getTime(),idregional));
    }
    @Override
    public List<Evento> obtenerEventosActivos(Integer idregional){
        return eventoRepository.findByActivoBetweenAndRegional_idregional(1,3,idregional);
    }
    @Override
    public List<Evento> obtenerEventoActivosAlianza(Integer activo,Integer alianza){
        return eventoRepository.findByActivoAndAlianza(activo,alianza);
    }

    @Override
    public Evento obtenerEventoActivo(Integer activo){
        return eventoRepository.findByActivo(activo);
    }
    public Evento obtenerEventoActivoRegional(Integer activo,Integer idregional){
        return eventoRepository.findByActivoAndRegional_idregional(activo,idregional);
    }
    @Override
    public Evento obtenerEvento(Integer idevento) {
        return eventoRepository.findByIdevento(idevento);
    }

    @Override
    public void eliminarEvento(Integer idevento) {
        Evento evento= new Evento();
        evento.setIdevento(idevento);
        eventoRepository.delete(evento);
    }
}
