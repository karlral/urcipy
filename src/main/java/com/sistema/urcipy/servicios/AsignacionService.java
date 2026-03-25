package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Asignacion;

import java.util.Set;


public interface AsignacionService {

    public Asignacion guardarAsignacion(Asignacion asignacion);

    public Set<Asignacion> obtenerAsignaciones();

    public Asignacion obtenerAsignacion(Integer idasignacion);

    public void eliminarAsignacion(Integer idasignacion);

}
