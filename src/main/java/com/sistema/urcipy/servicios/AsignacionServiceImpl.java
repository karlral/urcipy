package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Asignacion;
import com.sistema.urcipy.repositorios.AsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class AsignacionServiceImpl implements AsignacionService{

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public Asignacion guardarAsignacion(Asignacion asignacion){
        return asignacionRepository.save(asignacion);
    }

    @Override
    public Set<Asignacion> obtenerAsignaciones() {
        return new LinkedHashSet<>(asignacionRepository.findAll());
    }

    @Override
    public Asignacion obtenerAsignacion(Integer idasignacion) {
        return asignacionRepository.findById(idasignacion).get();
    }

    @Override
    public void eliminarAsignacion(Integer idasignacion) {
        Asignacion asignacion= new Asignacion();
        asignacion.setIdasignacion(idasignacion);
        asignacionRepository.delete(asignacion);
    }
}
