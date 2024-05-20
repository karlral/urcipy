package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Historial;

import java.util.Set;

public interface HistorialService {
    public Historial guardarHistorial(Historial entidad);
    
    public Set<Historial> obtenerHistoriales();

    public Historial obtenerHistorial(Integer identidad);

    public void eliminarHistorial(Integer identidad);

    public Set<Historial> obtenerHistoriales(String ci);

    public void cargarHistorial(Integer idevento);
}
