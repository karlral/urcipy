package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Resultimio;

import java.util.Set;


public interface ResultimioService {

    public Resultimio guardarResultimio(Resultimio resultimio);

    public Set<Resultimio> obtenerResultimioes();

    public Resultimio obtenerResultimio(Integer idresultimio);

    public void eliminarResultimio(Integer idresultimio);

    public void eliminarSendtimioEvento(Integer idevento);

}
