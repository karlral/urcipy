package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Regional;

import java.util.Set;


public interface RegionalService {

    public Regional guardarRegional(Regional regional);

    public Set<Regional> obtenerRegionales();

    public Regional obtenerRegional(Integer idregional);

    public void eliminarRegional(Integer idregional);

}
