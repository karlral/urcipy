package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Movimiento;
import com.sistema.urcipy.entidades.custom.Corredorank;
import com.sistema.urcipy.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.saveAndFlush(movimiento);
    }

    @Override
    public Set<Movimiento> obtenerMovimientoes(Integer idregional) {
        return new LinkedHashSet<>(movimientoRepository.findByConcepto_Regional_Idregional(idregional));
    }
    @Override
    public List<Corredorank> obtenerMovimientosRanking(Integer idregional) {
        return movimientoRepository.moviRankByIdregional(idregional);
    }

    @Override
    public Movimiento obtenerMovimiento(Integer idmovimiento) {
        return movimientoRepository.findById(idmovimiento).get();
    }

    @Override
    public void eliminarMovimiento(Integer idmovimiento) {
        Movimiento movimiento= new Movimiento();
        movimiento.setIdmovimiento(idmovimiento);
        movimientoRepository.delete(movimiento);
    }
}
