package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.entidades.CorredorClubRegional;

import java.util.Set;


public interface CorredorClubRegionalService {

    public CorredorClubRegional guardarCorredorClubRegional(CorredorClubRegional corredorClubRegional);

    public Set<CorredorClubRegional> obtenerCorredorClubRegionales();

    public CorredorClubRegional obtenerCorredorClubRegional(Integer idcorredorClubRegional);

    public void eliminarCorredorClubRegional(Integer idcorredorClubRegional);

    public Club obtenerClub(Integer idcorredor, Integer idRegional);

    public CorredorClubRegional obtenerCorreClubReg(Integer idcorredor, Integer idRegional);
}
