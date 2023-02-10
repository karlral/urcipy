package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Ciudad;
import com.sistema.urcipy.repositorios.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CiudadServiceImpl implements CiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public Ciudad guardarCiudad(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Set<Ciudad> obtenerCiudades() {
        return new LinkedHashSet<>(ciudadRepository.findAll());
    }

    @Override
    public Ciudad obtenerCiudad(Integer idciudad) {
        return ciudadRepository.findById(idciudad).get();
    }

    @Override
    public void eliminarCiudad(Integer idciudad) {
        Ciudad ciudad= new Ciudad();
        ciudad.setIdciudad(idciudad);
        ciudadRepository.delete(ciudad);
    }
}
