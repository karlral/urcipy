package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Region;

import java.util.Set;


public interface RegionService {

    public Region guardarRegion(Region region);

    public Set<Region> obtenerRegiones();

    public Region obtenerRegion(Integer idregion);

    public void eliminarRegion(Integer idregion);

}
