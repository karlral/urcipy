package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;

import java.util.Set;


public interface CorredorService {

    public Corredor guardarCorredor(Corredor corredor);

    public Set<Corredor> obtenerCorredores();

    public Corredor obtenerCorredor(Integer idcorredor);
    public Corredor obtenerCorredorCi(String ci);

    public void eliminarCorredor(Integer idcorredor);

    public Corredormen obtenerCorredormenCi(String ci);

    public Set<Corredormen> obtenerCorredoresmenCiNomApeClub(String buscado);
    public Set<Corredorbus> obtenerCorredoresbusCiNomApeClubDato(String buscado);
}
