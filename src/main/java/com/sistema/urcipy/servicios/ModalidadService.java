package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Modalidad;

import java.util.Set;


public interface ModalidadService {

    public Modalidad guardarModalidad(Modalidad modalidad);

    public Set<Modalidad> obtenerModalidades();

    public Modalidad obtenerModalidad(Integer idmodalidad);

    public void eliminarModalidad(Integer idmodalidad);

}