package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Tipo;
import com.sistema.urcipy.repositorios.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TipoServiceImpl implements TipoService{

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public Tipo guardarTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    @Override
    public Set<Tipo> obtenerTipoes() {
        return new LinkedHashSet<>(tipoRepository.findAll());
    }

    @Override
    public Tipo obtenerTipo(Integer idtipo) {
        return tipoRepository.findById(idtipo).get();
    }

    @Override
    public void eliminarTipo(Integer idtipo) {
        Tipo tipo= new Tipo();
        tipo.setIdtipo(idtipo);
        tipoRepository.delete(tipo);
    }
}
