package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Movimiento;
import com.sistema.urcipy.entidades.custom.Corredorank;

import java.util.List;
import java.util.Set;


public interface MovimientoService {

    public Movimiento guardarMovimiento(Movimiento movimiento);

    public Set<Movimiento> obtenerMovimientoes(Integer idregional);
    public Corredorank obtenerCiMovimientosRanking(String ci,Integer idregional);
    public List<Corredorank> obtenerMovimientosRanking(Integer idregional);

    public Movimiento obtenerMovimiento(Integer idmovimiento);

    public void eliminarMovimiento(Integer idmovimiento);

}
