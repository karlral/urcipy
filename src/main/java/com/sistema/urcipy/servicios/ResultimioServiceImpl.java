package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Resultimio;
import com.sistema.urcipy.repositorios.ResultimioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ResultimioServiceImpl implements ResultimioService{

    @Autowired
    private ResultimioRepository resultimioRepository;

    @Override
    public Resultimio guardarResultimio(Resultimio resultimio){

        return resultimioRepository.save(resultimio);
    }

    @Override
    public Set<Resultimio> obtenerResultimioes() {

        return new LinkedHashSet<>(resultimioRepository.findAll());
    }

    @Override
    public Resultimio obtenerResultimio(Integer idresultimio) {
        return resultimioRepository.findById(idresultimio).get();
    }

    @Override
    public void eliminarResultimio(Integer idresultimio) {
        Resultimio resultimio= new Resultimio();
        resultimio.setIdresultimio(idresultimio);
        resultimioRepository.delete(resultimio);
    }

    @Override
    @Transactional
    public void eliminarSendtimioEvento(Integer idevento) {
        resultimioRepository.deleteSendEvento(idevento);
    }
}
