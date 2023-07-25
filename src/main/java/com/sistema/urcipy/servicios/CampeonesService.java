package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Campeones;
import com.sistema.urcipy.entidades.custom.Anhocat;

import java.util.Set;


public interface CampeonesService {

    public Campeones guardarCampeones(Campeones campeones);

    public Set<Campeones> obtenerCampeoneses();

    public Campeones obtenerCampeones(Integer idcampeones);

    public void eliminarCampeones(Integer idcampeones);

    public Set<Anhocat> obtenerCategoriahInAnho();
    public Set<Campeones> obtenerCampeonesByAnhoAndIdcat(Integer idcategoriah);



}
