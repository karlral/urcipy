package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Historial;
import com.sistema.urcipy.repositorios.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public Historial guardarHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

   
    @Override
    public Set<Historial> obtenerHistoriales() {
        return new LinkedHashSet<>(historialRepository.findAll());
    }

    @Override
    public Historial obtenerHistorial(Integer idparticipante) {
        return historialRepository.findById(idparticipante).get();
    }

    @Override
    public void eliminarHistorial(Integer idparticipante) {
        Historial historial= new Historial();
        historial.setIdparticipante(idparticipante);
        historialRepository.delete(historial);
    }
    @Override
    public Set<Historial> obtenerHistoriales(String ci) {
        return new LinkedHashSet<>(historialRepository.findAllByCi(ci));
    }

    public Set<Historial> obtenerHistorialAnual(Integer anho){
        return new LinkedHashSet<>(historialRepository.searchByYearNative(anho));
    }

    @Override
    public void cargarHistorial(Integer idevento){
        historialRepository.cargahistorial(idevento);
    }
}
