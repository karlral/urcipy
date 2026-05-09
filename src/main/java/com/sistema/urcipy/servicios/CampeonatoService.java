package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Campeonato;

import java.util.Set;


public interface CampeonatoService {

    public Campeonato guardarCampeonato(Campeonato campeonato);

    public Set<Campeonato> obtenerCampeonatoes(Integer idregional);

    public Campeonato obtenerCampeonato(Integer idpuntaje);

    public void eliminarCampeonato(Integer idpuntaje);

}