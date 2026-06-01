package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.entidades.EventoTipo;
import com.sistema.urcipy.entidades.Tipo;
import com.sistema.urcipy.repositorios.CategoriaRepository;
import com.sistema.urcipy.repositorios.EventoTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventoTipoServiceImpl implements EventoTipoService{

    @Autowired
    private EventoTipoRepository eventoTipoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public EventoTipo guardarEventoTipo(EventoTipo eventoTipo){
        return eventoTipoRepository.save(eventoTipo);
    }

    @Override
    public Set<EventoTipo> obtenerEventoTipoes() {
        return new LinkedHashSet<>(eventoTipoRepository.findAll());
    }
    @Override
    public Set<Tipo> obtenerTiposEvento(Integer idevento) {
        Set<EventoTipo> eventoTipos=eventoTipoRepository.findAllByEvento_Idevento(idevento);
        return new LinkedHashSet<>(eventoTipos.stream().map(EventoTipo::getTipo).collect(Collectors.toSet()));
    }
    @Override
    public Set<Categoria> obtenerCategoriasEvento(Integer idevento) {
        Set<EventoTipo> eventoTipos=eventoTipoRepository.findAllByEvento_Idevento(idevento);
        Set<Categoria> categorias = new LinkedHashSet<>();
        Set<Tipo> tipos=eventoTipos.stream().map(EventoTipo::getTipo).collect(Collectors.toSet());
        Byte vtipo;
        for (Tipo tipo : tipos) {
            vtipo = tipo.getIdtipo().byteValue();
            categorias.addAll(categoriaRepository.findByTipo(vtipo));
        }
        return categorias;

    }

    @Override
    public EventoTipo obtenerEventoTipo(Integer ideventoTipo) {
        return eventoTipoRepository.findById(ideventoTipo).get();
    }

    @Override
    public void eliminarEventoTipo(Integer ideventoTipo) {
        EventoTipo eventoTipo= new EventoTipo();
        eventoTipo.setIdeventoTipo(ideventoTipo);
        eventoTipoRepository.delete(eventoTipo);
    }
}
