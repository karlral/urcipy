package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Puntaje;
import com.sistema.urcipy.repositorios.PuntajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PuntajeServiceImpl implements PuntajeService{

    @Autowired
    private PuntajeRepository puntajeRepository;

    @Override
    public Puntaje guardarPuntaje(Puntaje puntaje){
        return puntajeRepository.save(puntaje);
    }

    @Override
    public Set<Puntaje> obtenerPuntajees() {
        return new LinkedHashSet<>(puntajeRepository.findAll());
    }

    @Override
    public Puntaje obtenerPuntaje(Integer idpuntaje) {
        return puntajeRepository.findById(idpuntaje).get();
    }

    @Override
    public void eliminarPuntaje(Integer idpuntaje) {
        Puntaje puntaje= new Puntaje();
        puntaje.setIdpuntaje(idpuntaje);
        puntajeRepository.delete(puntaje);
    }
}