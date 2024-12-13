package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Trayecto;

import java.util.Set;


public interface TrayectoService {

    public Trayecto guardarTrayecto(Trayecto trayecto);

    public Set<Trayecto> obtenerTrayectoes();

    public Trayecto obtenerTrayecto(Integer idtrayecto);

    public void eliminarTrayecto(Integer idtrayecto);

}
