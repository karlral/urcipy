package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.repositorios.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CorredorServiceImpl implements CorredorService{

    @Autowired
    private CorredorRepository corredorRepository;

    @Override
    public Corredor guardarCorredor(Corredor corredor){
        return corredorRepository.save(corredor);
    }

    @Override
    public Set<Corredor> obtenerCorredores() {
        return new LinkedHashSet<>(corredorRepository.findAll());
    }

    @Override
    public Corredor obtenerCorredor(Integer idcorredor) {
        return corredorRepository.findById(idcorredor).get();
    }

    @Override
    public void eliminarCorredor(Integer idcorredor) {
        Corredor corredor= new Corredor();
        corredor.setIdcorredor(idcorredor);
        corredorRepository.delete(corredor);
    }
}
