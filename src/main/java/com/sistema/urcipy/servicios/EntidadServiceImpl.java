package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Entidad;
import com.sistema.urcipy.repositorios.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntidadServiceImpl implements EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public Entidad guardarEndidad(Entidad entidad) {
        return entidadRepository.save(entidad);
    }
}
