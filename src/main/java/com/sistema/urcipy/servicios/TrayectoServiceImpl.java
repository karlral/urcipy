package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Trayecto;
import com.sistema.urcipy.repositorios.TrayectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TrayectoServiceImpl implements TrayectoService{

    @Autowired
    private TrayectoRepository trayectoRepository;

    @Override
    public Trayecto guardarTrayecto(Trayecto trayecto){
        return trayectoRepository.save(trayecto);
    }

    @Override
    public Set<Trayecto> obtenerTrayectoes() {
        return new LinkedHashSet<>(trayectoRepository.findAll());
    }

    @Override
    public Trayecto obtenerTrayecto(Integer idtrayecto) {
        return trayectoRepository.findById(idtrayecto).get();
    }

    @Override
    public void eliminarTrayecto(Integer idtrayecto) {
        Trayecto trayecto= new Trayecto();
        trayecto.setIdtrayecto(idtrayecto);
        trayectoRepository.delete(trayecto);
    }
}
