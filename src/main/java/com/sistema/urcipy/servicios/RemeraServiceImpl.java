package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Remera;
import com.sistema.urcipy.repositorios.RemeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RemeraServiceImpl implements RemeraService{

    @Autowired
    private RemeraRepository remeraRepository;

    @Override
    public Remera guardarRemera(Remera remera){
        return remeraRepository.save(remera);
    }

    @Override
    public Set<Remera> obtenerRemeraes() {
        return new LinkedHashSet<>(remeraRepository.findAll());
    }

    @Override
    public Remera obtenerRemera(Integer idremera) {
        return remeraRepository.findById(idremera).get();
    }

    @Override
    public void eliminarRemera(Integer idremera) {
        Remera remera= new Remera();
        remera.setIdremera(idremera);
        remeraRepository.delete(remera);
    }
}
