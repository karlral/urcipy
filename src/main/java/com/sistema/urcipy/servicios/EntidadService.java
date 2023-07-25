package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Entidad;
import com.sistema.urcipy.entidades.Entidad;

import java.util.Set;

public interface EntidadService {
    public Entidad guardarEndidad(Entidad entidad);
    
    public Set<Entidad> obtenerEntidades();

    public Entidad obtenerEntidad(Integer identidad);

    public void eliminarEntidad(Integer identidad);

}
