package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Campeonato;
import com.sistema.urcipy.repositorios.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CampeonatoServiceImpl implements CampeonatoService{

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Override
    public Campeonato guardarCampeonato(Campeonato campeonato){
        return campeonatoRepository.save(campeonato);
    }

    @Override
    public Set<Campeonato> obtenerCampeonatoes(Integer idregional) {
        return new LinkedHashSet<>(campeonatoRepository.findByRegional_Idregional(idregional));
    }

    @Override
    public Campeonato obtenerCampeonato(Integer idcampeonato) {
        return campeonatoRepository.findById(idcampeonato).get();
    }

    @Override
    public void eliminarCampeonato(Integer idcampeonato) {
        Campeonato campeonato= new Campeonato();
        campeonato.setIdcampeonato(idcampeonato);
        campeonatoRepository.delete(campeonato);
    }
}