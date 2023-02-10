package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Ciudad;

import java.util.Set;


public interface CiudadService {

    public Ciudad guardarCiudad(Ciudad ciudad);

    public Set<Ciudad> obtenerCiudades();

    public Ciudad obtenerCiudad(Integer idciudad);

    public void eliminarCiudad(Integer idciudad);

}
