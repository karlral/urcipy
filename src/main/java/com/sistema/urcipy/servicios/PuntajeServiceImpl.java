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
    public Set<Puntaje> obtenerPuntajees(Integer idregional) {
        return new LinkedHashSet<>(puntajeRepository.findByRegional_Idregional(idregional));
    }

    @Override
    public Puntaje obtenerPuntaje(Integer idpuntaje) {
        return puntajeRepository.findById(idpuntaje).get();
    }
    @Override
    public Integer obtenerPunto(Integer posicion,Integer idregional ){
        return puntajeRepository.findByPosicionAndRegional_Idregional(posicion,idregional).getPuntos();
    }

    @Override
    public void eliminarPuntaje(Integer idpuntaje) {
        Puntaje puntaje= new Puntaje();
        puntaje.setIdpuntaje(idpuntaje);
        puntajeRepository.delete(puntaje);
    }
}