package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Remera;

import java.util.Set;


public interface RemeraService {

    public Remera guardarRemera(Remera remera);

    public Set<Remera> obtenerRemeraes();

    public Remera obtenerRemera(Integer idremera);

    public void eliminarRemera(Integer idremera);

}
