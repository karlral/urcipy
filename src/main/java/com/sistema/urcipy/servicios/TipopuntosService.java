package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Tipopuntos;

import java.util.Set;


public interface TipopuntosService {

    public Tipopuntos guardarTipopuntos(Tipopuntos tipopuntos);

    public Set<Tipopuntos> obtenerTipopuntoses();

    public Tipopuntos obtenerTipopuntos(Integer idtipopuntos);

    public void eliminarTipopuntos(Integer idtipopuntos);

}
