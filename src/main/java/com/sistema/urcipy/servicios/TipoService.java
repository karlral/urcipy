package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Tipo;

import java.util.Set;


public interface TipoService {

    public Tipo guardarTipo(Tipo tipo);

    public Set<Tipo> obtenerTipoes();

    public Tipo obtenerTipo(Integer idtipo);

    public void eliminarTipo(Integer idtipo);

}
