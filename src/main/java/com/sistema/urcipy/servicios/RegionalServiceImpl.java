package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.repositorios.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RegionalServiceImpl implements RegionalService{

    @Autowired
    private RegionalRepository regionalRepository;

    @Override
    public Regional guardarRegional(Regional regional){
        return regionalRepository.save(regional);
    }

    @Override
    public Set<Regional> obtenerRegionales() {
        return new LinkedHashSet<>(regionalRepository.findAll());
    }

    @Override
    public Regional obtenerRegional(Integer idregional) {
        return regionalRepository.findById(idregional).get();
    }

    @Override
    public void eliminarRegional(Integer idregional) {
        Regional regional= new Regional();
        regional.setIdregional(idregional);
        regionalRepository.delete(regional);
    }
}
