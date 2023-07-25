package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Entidad;
import com.sistema.urcipy.repositorios.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class EntidadServiceImpl implements EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public Entidad guardarEndidad(Entidad entidad) {
        return entidadRepository.save(entidad);
    }

   
    @Override
    public Set<Entidad> obtenerEntidades() {
        return new LinkedHashSet<>(entidadRepository.findAll());
    }

    @Override
    public Entidad obtenerEntidad(Integer identidad) {
        return entidadRepository.findById(identidad).get();
    }

    @Override
    public void eliminarEntidad(Integer identidad) {
        Entidad entidad= new Entidad();
        entidad.setIdentidad(identidad);
        entidadRepository.delete(entidad);
    }
}
