package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Tipopuntos;
import com.sistema.urcipy.repositorios.TipopuntosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TipopuntosServiceImpl implements TipopuntosService{

    @Autowired
    private TipopuntosRepository tipopuntosRepository;

    @Override
    public Tipopuntos guardarTipopuntos(Tipopuntos tipopuntos){
        return tipopuntosRepository.save(tipopuntos);
    }

    @Override
    public Set<Tipopuntos> obtenerTipopuntoses() {
        return new LinkedHashSet<>(tipopuntosRepository.findAll());
    }

    @Override
    public Tipopuntos obtenerTipopuntos(Integer idtipopuntos) {
        return tipopuntosRepository.findById(idtipopuntos).get();
    }

    @Override
    public void eliminarTipopuntos(Integer idtipopuntos) {
        Tipopuntos tipopuntos= new Tipopuntos();
        tipopuntos.setIdtipopuntos(idtipopuntos);
        tipopuntosRepository.delete(tipopuntos);
    }
}
