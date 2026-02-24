package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.entidades.custom.Clube;

import java.util.Set;


public interface ClubService {

    public Club guardarClub(Club club);

    public Set<Club> obtenerClubes();
    public Set<Club> obtenerClubes(Integer idModalidad);
    public Set<Clube> obtenerClube(Integer idModalidad);

    public Club obtenerClub(Integer idclub);

    public void eliminarClub(Integer idclub);

}
