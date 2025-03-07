package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Modalidad;
import com.sistema.urcipy.repositorios.ModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ModalidadServiceImpl implements ModalidadService{

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Override
    public Modalidad guardarModalidad(Modalidad modalidad){
        return modalidadRepository.save(modalidad);
    }

    @Override
    public Set<Modalidad> obtenerModalidades() {
        return new LinkedHashSet<>(modalidadRepository.findAll());
    }

    @Override
    public Modalidad obtenerModalidad(Integer idmodalidad) {
        return modalidadRepository.findById(idmodalidad).get();
    }

    @Override
    public void eliminarModalidad(Integer idmodalidad) {
        Modalidad modalidad= new Modalidad();
        modalidad.setIdmodalidad(idmodalidad);
        modalidadRepository.delete(modalidad);
    }
}