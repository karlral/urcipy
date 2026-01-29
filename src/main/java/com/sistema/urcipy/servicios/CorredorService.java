package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;

import java.util.List;
import java.util.Set;


public interface CorredorService {

    public Corredor guardarCorredor(Corredor corredor);
    public void guardarCorredores(List<Corredor> corredores);

    public Set<Corredor> obtenerCorredores();

    public Set<Corredor> obtenerCorredores(Integer idregional);

    public Corredor obtenerCorredor(Integer idcorredor);
    public Corredor obtenerCorredorCi(String ci,Integer idregional);

    public void eliminarCorredor(Integer idcorredor);

    public Corredormen obtenerCorredormenCi(String ci, Integer idregional);

    public Corredorbus obtenerCorredorbusCi(String ci, Integer idregional);

    public Set<Corredormen> obtenerCorredoresmenCiNomApeClub(String buscado, Integer idregional);
    public Set<Corredorbus> obtenerCorredoresbusCiNomApeClubDato(String buscado, Integer idregional);
    public void catAlianza(Integer idpersona,Integer idcategoria,Integer idclub);

    public void updateCatCorre(Integer idcorredor,Integer idcategoria);
}
