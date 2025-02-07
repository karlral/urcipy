package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Puntaje;

import java.util.Set;


public interface PuntajeService {

    public Puntaje guardarPuntaje(Puntaje puntaje);

    public Set<Puntaje> obtenerPuntajees(Integer idregional);

    public Puntaje obtenerPuntaje(Integer idpuntaje);

    public Integer obtenerPunto(Integer posicion,Integer idregional);

    public void eliminarPuntaje(Integer idpuntaje);

}