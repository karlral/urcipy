package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Campeones;
import com.sistema.urcipy.entidades.custom.Anhocat;
import com.sistema.urcipy.repositorios.CampeonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CampeonesServiceImpl implements CampeonesService{

    @Autowired
    private CampeonesRepository campeonesRepository;

    @Override
    public Campeones guardarCampeones(Campeones campeones){
        return campeonesRepository.save(campeones);
    }

    @Override
    public Set<Campeones> obtenerCampeoneses() {
        return new LinkedHashSet<>(campeonesRepository.findAll());
    }

    @Override
    public Campeones obtenerCampeones(Integer idcampeones) {
        return campeonesRepository.findById(idcampeones).get();
    }

    @Override
    public void eliminarCampeones(Integer idcampeones) {
        Campeones campeones= new Campeones();
        campeones.setIdcampeones(idcampeones);
        campeonesRepository.delete(campeones);
    }

    @Override
    public Set<Anhocat> obtenerCategoriahInAnho(){
        return new LinkedHashSet<>(campeonesRepository.categoriahByAnhoNative());
    }

    @Override
    public Set<Campeones> obtenerCampeonesByAnhoAndIdcat(Integer idcategoriah){
        return new LinkedHashSet<>(campeonesRepository.findCampeonesByCategoriahIdcategoriah(idcategoriah));
    }
}
